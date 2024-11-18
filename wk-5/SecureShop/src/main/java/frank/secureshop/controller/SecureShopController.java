package frank.secureshop.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SecureShopController {

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

    @GetMapping("regular-user-key")
    @PreAuthorize("hasAnyRole('ROLE_REGULAR', 'ROLE_STAFF', 'ROLE_ADMIN')")
    public String getRegularApiKey(@Value("${REGULAR_USER_API_KEY}") String regularUserApiKey) {
        return regularUserApiKey;
    }

    
}
