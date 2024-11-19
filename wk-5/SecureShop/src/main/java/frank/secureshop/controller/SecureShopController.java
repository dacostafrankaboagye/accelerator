package frank.secureshop.controller;

import frank.secureshop.repository.SecureShopUser;
import frank.secureshop.repository.SecureShopUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

/**
 * Controller class for handling Secure Shop operations.
 * Provides endpoints for API key retrieval, user creation, retrieval, updating, and deletion.
 * Access to specific endpoints is secured using roles.
 */
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SecureShopController {

    private final PasswordEncoder passwordEncoder;
    private final SecureShopUserRepository secureShopUserRepository;

    /**
     * Retrieves the public API key.
     *
     * @param publicApiKey the public API key value loaded from configuration
     * @return the public API key as a string
     */
    @GetMapping("/public-key")
    public String getPublicApiKey(@Value("${public.apiKey}") String publicApiKey) {
        return publicApiKey;
    }

    /**
     * Retrieves the admin API key. Only accessible by users with the "ROLE_ADMIN".
     *
     * @param adminApiKey the admin API key value loaded from configuration
     * @return the admin API key as a string
     */
    @GetMapping("/admin-key")
    @Secured("ROLE_ADMIN")
    public String getAdminApiKey(@Value("${ADMIN_API_KEY}") String adminApiKey) {
        return adminApiKey;
    }

    /**
     * Retrieves the staff API key. Accessible by users with roles "STAFF" or "ADMIN".
     *
     * @param staffApiKey the staff API key value loaded from configuration
     * @return the staff API key as a string
     */
    @GetMapping("/staff-key")
    @PreAuthorize("hasRole('STAFF') or hasRole('ADMIN')")
    public String getStaffApiKey(@Value("${STAFF_API_KEY}") String staffApiKey) {
        return staffApiKey;
    }

    /**
     * Retrieves the regular user API key. Accessible by users with roles "REGULAR", "STAFF", or "ADMIN".
     *
     * @param regularUserApiKey the regular user API key value loaded from configuration
     * @return the regular user API key as a string
     */
    @GetMapping("/regular-user-key")
    @PreAuthorize("hasAnyRole('ROLE_REGULAR', 'ROLE_STAFF', 'ROLE_ADMIN')")
    public String getRegularApiKey(@Value("${REGULAR_USER_API_KEY}") String regularUserApiKey) {
        return regularUserApiKey;
    }

    /**
     * Creates a new user and stores it in the database.
     *
     * @param secureShopUser the user details to create
     * @return a response entity containing the created user or an error message
     */
    @PostMapping("/create-user")
    public ResponseEntity<?> creatUser(@RequestBody SecureShopUser secureShopUser) {

        try {
            secureShopUser.setPassword(passwordEncoder.encode(secureShopUser.getPassword()));
            return ResponseEntity.status(HttpStatus.CREATED).body(secureShopUserRepository.save(secureShopUser));

        } catch (Exception e) {
            // For the purpose of the lab, I am using Internal server error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

    }

    /**
     * Retrieves a user by ID. Accessible by users with roles "REGULAR", "STAFF", or "ADMIN".
     *
     * @param id        the ID of the user to retrieve
     * @param principal the authenticated user's principal
     * @return a response entity containing the user details
     */
    @GetMapping("/get-user/{id}")
    @PreAuthorize("hasAnyRole('ROLE_REGULAR', 'ROLE_STAFF', 'ROLE_ADMIN')")
    public ResponseEntity<?> getUserById(@PathVariable Long id, Principal principal) {
        // we are using AOP for security. cool
        return ResponseEntity.ok(getSecureShopUserAfterAOP(principal));
    }

    /**
     * Updates the details of an existing user. Accessible by users with roles "REGULAR", "STAFF", or "ADMIN".
     *
     * @param id          the ID of the user to update
     * @param principal   the authenticated user's principal
     * @param updatedUser the updated user details
     * @return a response entity containing the updated user details
     */
    @PutMapping("/update-user/{id}")
    @PreAuthorize("hasAnyRole('ROLE_REGULAR', 'ROLE_STAFF', 'ROLE_ADMIN')")
    public ResponseEntity<?> updateUser(@PathVariable Long id, Principal principal, @RequestBody SecureShopUser updatedUser) {

            SecureShopUser user = getSecureShopUserAfterAOP(principal);
            user.setUsername(updatedUser.getUsername());
            user.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
            user.setRole(updatedUser.getRole());
            return ResponseEntity.ok(secureShopUserRepository.save(user));

    }

    /**
     * Deletes a user by ID. Accessible by users with roles "REGULAR", "STAFF", or "ADMIN".
     *
     * @param id        the ID of the user to delete
     * @param principal the authenticated user's principal
     * @return a response entity indicating the success or failure of the operation
     */
    @DeleteMapping("/delete-user/{id}")
    @PreAuthorize("hasAnyRole('ROLE_REGULAR', 'ROLE_STAFF', 'ROLE_ADMIN')")
    public ResponseEntity<?> deleteUser(@PathVariable Long id, Principal principal) {
        try {
            if (secureShopUserRepository.existsById(id)) {
                secureShopUserRepository.deleteById(id);
                return ResponseEntity.ok("User deleted successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    /**
     * Retrieves the authenticated user's details after AOP processing.
     *
     * @param principal the authenticated user's principal
     * @return the details of the authenticated user
     */
    private SecureShopUser getSecureShopUserAfterAOP(Principal principal){
        return secureShopUserRepository.findSecureShopUserByUsername(principal.getName());
    }

}
