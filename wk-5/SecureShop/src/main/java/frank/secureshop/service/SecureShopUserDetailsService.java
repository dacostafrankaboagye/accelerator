package frank.secureshop.service;

import frank.secureshop.repository.SecureShopUser;
import frank.secureshop.repository.SecureShopUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service class that implements {@link UserDetailsService} to load user-specific data.
 * This service is used by Spring Security to authenticate and authorize users based on their username.
 */
@Service
@RequiredArgsConstructor
public class SecureShopUserDetailsService implements UserDetailsService {

    private final SecureShopUserRepository secureShopUserRepository;

    /**
     * Loads user details by their username. This method is used by Spring Security during authentication.
     *
     * @param username the username of the user to be loaded
     * @return a UserDetails object containing the user's information (username, password, and roles)
     * @throws UsernameNotFoundException if the username is not found in the database
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<SecureShopUser> secureShopUserOptional = secureShopUserRepository.findByUsername(username);
        if (secureShopUserOptional.isPresent()) {
            var secureShopUser = secureShopUserOptional.get();
            return User.builder()
                    .username(secureShopUser.getUsername())
                    .password(secureShopUser.getPassword())
                    .roles(getRole(secureShopUser))
                    .build();

        } else {
            throw new UsernameNotFoundException("Username: " + username + " is not found");
        }

    }

    /**
     * Extracts the roles of the user from their role field.
     * If no roles are provided, the user will be assigned the "REGULAR" role by default.
     *
     * @param secureShopUser the user whose roles need to be retrieved
     * @return an array of role strings
     */
    private String[] getRole(SecureShopUser secureShopUser) {
        // if the user has no role, it will be assigned USER
        if (secureShopUser.getRole() == null) {
            return new String[]{"REGULAR"};  // return ["REGULAR"]
        }
        // if something was provided --> it is going to be in this form "USER, ADMIN"
        return secureShopUser.getRole().split(",");  // it returns String[]
    }
}
