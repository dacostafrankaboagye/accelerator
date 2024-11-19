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

@Service
@RequiredArgsConstructor
public class SecureShopUserDetailsService implements UserDetailsService {

    private final SecureShopUserRepository secureshopUserRepository;


    private final SecureShopUserRepository secureShopUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<SecureShopUser> secureShopUserOptional = secureShopUserRepository.findByUsername(username);
        if(secureShopUserOptional.isPresent()){
            var secureShopUser =secureShopUserOptional.get();
            return User.builder()
                    .username(secureShopUser.getUsername())
                    .password(secureShopUser.getPassword())
                    .roles(getRole(secureShopUser))
                    .build();

        }else {
            throw new UsernameNotFoundException("Username: " + username + " is not found");
        }

    }

    private String[] getRole(SecureShopUser secureShopUser) {
        // if the user has no role, it will be assigned USER
        if(secureShopUser.getRole() == null){
            return new String[]{"REGULAR"};  // return ["REGULAR"]
        }
        // if something was provided --> it is going to be in this form "USER, ADMIN"
        return secureShopUser.getRole().split(",");  // it returns String[]
    }
}
