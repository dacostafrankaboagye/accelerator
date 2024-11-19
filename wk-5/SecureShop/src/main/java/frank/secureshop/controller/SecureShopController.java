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
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SecureShopController {

    private final PasswordEncoder passwordEncoder;
    private final SecureShopUserRepository secureShopUserRepository;

    @GetMapping("/public-key")
    public String getPublicApiKey(@Value("${public.apiKey}") String publicApiKey) {
        return publicApiKey;
    }

    @GetMapping("/admin-key")
    @Secured("ROLE_ADMIN")
    public String getAdminApiKey(@Value("${ADMIN_API_KEY}") String adminApiKey) {
        return adminApiKey;
    }

    @GetMapping("/staff-key")
    @PreAuthorize("hasRole('STAFF') or hasRole('ADMIN')")
    public String getStaffApiKey(@Value("${STAFF_API_KEY}") String staffApiKey) {
        return staffApiKey;
    }

    @GetMapping("/regular-user-key")
    @PreAuthorize("hasAnyRole('ROLE_REGULAR', 'ROLE_STAFF', 'ROLE_ADMIN')")
    public String getRegularApiKey(@Value("${REGULAR_USER_API_KEY}") String regularUserApiKey) {
        return regularUserApiKey;
    }

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

    @GetMapping("/get-user/{id}")
    @PreAuthorize("hasAnyRole('ROLE_REGULAR', 'ROLE_STAFF', 'ROLE_ADMIN')")
    public ResponseEntity<?> getUserById(@PathVariable Long id, Principal principal) {
        // we are using AOP for security. cool
        return ResponseEntity.ok(getSecureShopUserAfterAOP(principal));
    }

    @PutMapping("/update-user/{id}")
    @PreAuthorize("hasAnyRole('ROLE_REGULAR', 'ROLE_STAFF', 'ROLE_ADMIN')")
    public ResponseEntity<?> updateUser(@PathVariable Long id, Principal principal, @RequestBody SecureShopUser updatedUser) {

            SecureShopUser user = getSecureShopUserAfterAOP(principal);
            user.setUsername(updatedUser.getUsername());
            user.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
            user.setRole(updatedUser.getRole());
            return ResponseEntity.ok(secureShopUserRepository.save(user));

    }

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

    private SecureShopUser getSecureShopUserAfterAOP(Principal principal){
        return secureShopUserRepository.findSecureShopUserByUsername(principal.getName());
    }

}
