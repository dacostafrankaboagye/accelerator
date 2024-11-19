package frank.secureshop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for handling operations specific to staff users in the Secure Shop application.
 * Provides an endpoint to greet staff members.
 */
@RestController
@RequestMapping("/staff")
public class StaffController {

    /**
     * Provides a welcome message for staff users.
     *
     * @return a welcome message string for staff users
     */
    @GetMapping
    public String staffAccess() {
        return "Welcome, Staff!";
    }
}
