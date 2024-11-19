package frank.secureshop.controller;

import frank.secureshop.service.SecureShopUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final SecureShopUserDetailsService secureShopUserDetailsService;

    @GetMapping
    public String adminAccess() {
        return "Welcome, Admin!";
    }

    @GetMapping("/getInfo")
    public ResponseEntity<?> adminInfo(Principal principal) {

        UserDetails adminDetails = secureShopUserDetailsService.loadUserByUsername(principal.getName());

        return ResponseEntity.ok(adminDetails);
    }
}
