package frank.secureshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repository interface for interacting with the {@link SecureShopUser} entity.
 * Provides methods for retrieving users from the database by their username.
 */
public interface SecureShopUserRepository extends JpaRepository<SecureShopUser, Long> {

    /**
     * Finds a user by their username.
     * Returns an {@link Optional} to handle cases where the user may not exist.
     *
     * @param username the username of the user to find
     * @return an Optional containing the SecureShopUser if found, or empty if not
     */
    Optional<SecureShopUser> findByUsername(String username);

    /**
     * Finds a user by their username with the assumption that the user exists.
     * This method should be used after a security check, as it returns a non-Optional result.
     *
     * @param username the username of the user to find
     * @return the SecureShopUser associated with the given username
     */
    SecureShopUser findSecureShopUserByUsername(String username);
}
