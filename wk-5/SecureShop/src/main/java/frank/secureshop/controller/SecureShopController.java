package frank.secureshop.controller;

import frank.secureshop.repository.SecureShopUser;
import frank.secureshop.repository.SecureShopUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/register/user")
    public SecureShopUser creatUser(@RequestBody SecureShopUser secureShopUser){
        secureShopUser.setPassword(passwordEncoder.encode(secureShopUser.getPassword()));
        return secureShopUserRepository.save(secureShopUser);

    }

    
}
