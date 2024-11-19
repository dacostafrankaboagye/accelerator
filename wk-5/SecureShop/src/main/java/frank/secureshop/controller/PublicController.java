package frank.secureshop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for handling public access in the Secure Shop application.
 * Provides an endpoint accessible to all users without authentication.
 */
@RestController
@RequestMapping("/public")
public class PublicController {

    /**
     * Provides a public welcome message.
     *
     * @return a welcome message string accessible to everyone
     */
    @GetMapping
    public String publicMethod() {
        return "Welcome, everyone!";
    }
}
