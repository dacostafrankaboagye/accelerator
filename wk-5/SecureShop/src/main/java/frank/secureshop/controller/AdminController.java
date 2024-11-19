package frank.secureshop.controller;

import frank.secureshop.repository.SecureShopUserRepository;
import frank.secureshop.service.SecureShopUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Controller class for handling admin-specific operations in the Secure Shop application.
 * Provides endpoints for accessing admin information and managing users.
 */
@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final SecureShopUserDetailsService secureShopUserDetailsService;
    private final SecureShopUserRepository secureShopUserRepository;

    /**
     * Provides a welcome message for admin users.
     *
     * @return a welcome message string
     */
    @GetMapping
    public String adminAccess() {
        return "Welcome, Admin!";
    }

    /**
     * Retrieves the details of the authenticated admin user.
     *
     * @param principal the authenticated user's principal
     * @return a response entity containing the admin's user details
     */
    @GetMapping("/getInfo")
    public ResponseEntity<?> adminInfo(Principal principal) {

        UserDetails adminDetails = secureShopUserDetailsService.loadUserByUsername(principal.getName());

        return ResponseEntity.ok(adminDetails);
    }

    /**
     * Retrieves a list of all users in the system.
     *
     * @return a response entity containing the list of all users
     */
    @GetMapping("/get-all-users")
    public ResponseEntity<?> getAllUsers() {
        return new ResponseEntity<>(secureShopUserRepository.findAll(), HttpStatus.OK);
    }
}
