package frank.secureshop.configuration;

import frank.secureshop.repository.SecureShopUserRepository;
import frank.secureshop.service.SecureShopUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableMethodSecurity(securedEnabled = true, prePostEnabled = true)
@RequiredArgsConstructor
public class SecureShopSecurityConfig {

    private final SecureShopUserDetailsService secureShopUserDetailsService;

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


    /*
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

     */

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Profile("jpa")
    public UserDetailsService jpaUserDetailsService(){
        return secureShopUserDetailsService;
    }

    @Bean
    @Profile("jpa")
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(secureShopUserDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

}
