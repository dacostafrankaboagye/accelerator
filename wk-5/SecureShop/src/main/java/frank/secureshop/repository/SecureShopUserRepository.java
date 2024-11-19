package frank.secureshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SecureShopUserRepository extends JpaRepository<SecureShopUser, Long> {
    Optional<SecureShopUser> findByUsername(String username);

    // use this after a security check - because we are sure to get it
    SecureShopUser findSecureShopUserByUsername(String username);
}
