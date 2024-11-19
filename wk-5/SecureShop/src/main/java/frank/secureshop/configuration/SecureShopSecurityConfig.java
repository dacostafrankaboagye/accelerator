package frank.secureshop.configuration;

import frank.secureshop.service.SecureShopUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.*;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * Configures the security settings for the SecureShop application.
 * This includes HTTP security settings, user authentication, and authorization rules.
 * It defines roles for Admin, Staff, Regular User, and Public access.
 */
@Configuration
@EnableMethodSecurity(securedEnabled = true, prePostEnabled = true)
@RequiredArgsConstructor
@EnableAspectJAutoProxy
@ComponentScan("frank.secureshop")
public class SecureShopSecurityConfig {

    private final SecureShopUserDetailsService secureShopUserDetailsService;

    /**
     * Configures the HTTP security settings.
     * This includes setting authorization rules for different URL patterns, enabling HTTP basic authentication,
     * and disabling CSRF protection.
     *
     * @param httpSecurity the HttpSecurity object to configure
     * @return the configured SecurityFilterChain
     * @throws Exception if there is an error during configuration
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorizationManagerRequestMatcherRegistry -> {
                    authorizationManagerRequestMatcherRegistry.requestMatchers("/admin/**").hasRole("ADMIN");
                    authorizationManagerRequestMatcherRegistry.requestMatchers("/staff/**").hasRole("STAFF");
                    authorizationManagerRequestMatcherRegistry.requestMatchers("/regular-user/**").hasRole("REGULAR");
                    authorizationManagerRequestMatcherRegistry.requestMatchers("/public/**").permitAll();
                    authorizationManagerRequestMatcherRegistry.requestMatchers("/api/**").permitAll();
                    authorizationManagerRequestMatcherRegistry.anyRequest().authenticated();
                })
                .httpBasic(withDefaults())
                .build();
    }


    /**
     * Provides an in-memory user details service for testing or development purposes.
     * This creates a set of hard-coded users with different roles: ADMIN, STAFF, and REGULAR.
     * This bean is used when the "in-memory" profile is active.
     *
     * @return an InMemoryUserDetailsManager containing the test users
     */
    @Bean
    @Profile("in-memory")
    public InMemoryUserDetailsManager inMemoryUserDetailsService() {
        UserDetails regularUser = User
                .withUsername("Alexis")
                .password(passwordEncoder().encode("Alex123"))
                .roles("REGULAR")
                .build();

        UserDetails adminUser = User
                .withUsername("Jordan")
                .password(passwordEncoder().encode("Admin123"))
                .roles("ADMIN")
                .build();

        UserDetails staffUser = User
                .withUsername("Taylor")
                .password(passwordEncoder().encode("Staff123"))
                .roles("STAFF")
                .build();

        return new InMemoryUserDetailsManager(regularUser, adminUser, staffUser);

    }

    /**
     * Provides a PasswordEncoder bean for encoding user passwords.
     * This method uses BCrypt for encoding passwords securely.
     *
     * @return a BCryptPasswordEncoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Provides a UserDetailsService bean for JPA-based user authentication.
     * This method uses SecureShopUserDetailsService for loading user details from the database.
     * This bean is used when the "jpa" profile is active.
     *
     * @return the SecureShopUserDetailsService
     */
    @Bean
    @Profile("jpa")
    public UserDetailsService jpaUserDetailsService(){
        return secureShopUserDetailsService;
    }

    /**
     * Configures an AuthenticationProvider bean for JPA-based authentication.
     * This method uses DaoAuthenticationProvider with SecureShopUserDetailsService and a PasswordEncoder.
     * This bean is used when the "jpa" profile is active.
     *
     * @return an AuthenticationProvider configured for JPA-based authentication
     */
    @Bean
    @Profile("jpa")
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(secureShopUserDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

}
