package frank.secureshop.configuration;

import frank.secureshop.repository.SecureShopUser;
import frank.secureshop.repository.SecureShopUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Configuration class for initializing default users in the Secure Shop application.
 * This class checks if the user repository is empty and populates it with default users (ADMIN, STAFF, REGULAR).
 */
@Configuration
@RequiredArgsConstructor
public class DataLoader {

    private final SecureShopUserRepository secureShopUserRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * CommandLineRunner bean that runs on application startup to initialize default users.
     * Adds users with predefined roles if the repository is empty.
     *
     * @return a CommandLineRunner to execute user initialization on application startup
     */
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
