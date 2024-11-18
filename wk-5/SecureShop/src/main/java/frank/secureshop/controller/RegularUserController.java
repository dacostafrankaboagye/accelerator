package frank.secureshop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/regular-user")
public class RegularUserController {

    @GetMapping
    public String regularUserAccess() {
        return "Welcome, Regular User!";
    }
}
