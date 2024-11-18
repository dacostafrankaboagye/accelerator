package frank.secureshop.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecureShopSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorizationManagerRequestMatcherRegistry -> {
                    authorizationManagerRequestMatcherRegistry.requestMatchers("/admin/**").hasRole("ADMIN");
                    authorizationManagerRequestMatcherRegistry.requestMatchers("/staff/**").hasRole("STAFF");
                    authorizationManagerRequestMatcherRegistry.requestMatchers("/regular-user/**").hasRole("REGULAR");
                    authorizationManagerRequestMatcherRegistry.requestMatchers("/public/**").permitAll();
                    authorizationManagerRequestMatcherRegistry.anyRequest().authenticated();
                })
                .httpBasic(withDefaults())
                .build();
    }


    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
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

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
