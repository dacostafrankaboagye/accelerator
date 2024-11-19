package frank.secureshop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for handling operations specific to regular users in the Secure Shop application.
 * Provides an endpoint to greet regular users.
 */
@RestController
@RequestMapping("/regular-user")
public class RegularUserController {

    /**
     * Provides a welcome message for regular users.
     *
     * @return a welcome message string for regular users
     */
    @GetMapping
    public String regularUserAccess() {
        return "Welcome, Regular User!";
    }
}
