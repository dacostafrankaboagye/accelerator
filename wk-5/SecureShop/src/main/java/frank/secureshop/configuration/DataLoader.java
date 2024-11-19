package frank.secureshop.configuration;

import frank.secureshop.repository.SecureShopUser;
import frank.secureshop.repository.SecureShopUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class DataLoader {

    private final SecureShopUserRepository secureShopUserRepository;
    private final PasswordEncoder passwordEncoder;

    @Bean
    public CommandLineRunner init() {
        return args -> {
            if (secureShopUserRepository.count() == 0) {
                // Add ADMIN user
                secureShopUserRepository.save(new SecureShopUser(
                        null,
                        "Jordan",
                        passwordEncoder.encode("Admin123"),
                        "ADMIN"
                ));

                // Add STAFF user
                secureShopUserRepository.save(new SecureShopUser(
                        null,
                        "Taylor",
                        passwordEncoder.encode("Staff123"),
                        "STAFF"
                ));

                // Add REGULAR user
                secureShopUserRepository.save(new SecureShopUser(
                        null,
                        "Alexis",
                        passwordEncoder.encode("Alex123"),
                        "REGULAR"
                ));

                System.out.println("Users initialized successfully!");
            } else {
                System.out.println("Users already initialized. Skipping population.");
            }
        };

    }
}
