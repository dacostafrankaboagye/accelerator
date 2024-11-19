package frank.secureshop.configuration;

import frank.secureshop.exception.SecureShopException;
import frank.secureshop.repository.SecureShopUser;
import frank.secureshop.repository.SecureShopUserRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.security.Principal;

import static org.springframework.http.HttpStatus.*;

/**
 * Aspect for enforcing security rules on CRUD operations in the SecureShopController.
 * This ensures that the user making the request is allowed to perform actions on their own data.
 */
@Component
@Aspect
@RequiredArgsConstructor
public class SecureShopCrudSecurity {

    private final SecureShopUserRepository secureShopUserRepository;


    /**
     * Advice that checks the user performing the operation matches the user being operated on.
     * This is applied to the getUserById, updateUser, and deleteUser methods in the SecureShopController.
     *
     * @param joinPoint the join point of the intercepted method
     */
    @Before(
            "execution(* frank.secureshop.controller.SecureShopController.getUserById(..)) || " +
            "execution(* frank.secureshop.controller.SecureShopController.updateUser(..)) ||" +
            "execution(* frank.secureshop.controller.SecureShopController.deleteUser(..))"
    )
    public void crossCheckUser(JoinPoint joinPoint){
        checks(joinPoint);
        Long id =  (Long)joinPoint.getArgs()[0];

        SecureShopUser user = secureShopUserRepository.findById(id).orElseThrow(
                ()-> SecureShopException
                .builder()
                .httpStatus(NOT_FOUND)
                .message("User not found")
                .build()
        );

        Principal principal = (Principal)joinPoint.getArgs()[1];

        if(!user.getUsername().equals(principal.getName())){
            throw SecureShopException
                    .builder()
                    .httpStatus(CONFLICT)
                    .message("Username and Principal do not match")
                    .build();
        }

    }


    /**
     * Perform general checks to ensure that required arguments are provided in the method call.
     * Throws exceptions if arguments are missing or invalid.
     *
     * @param joinPoint the join point of the intercepted method
     */
    public void checks(JoinPoint joinPoint){
        if(joinPoint.getArgs().length == 0){
            throw SecureShopException
                    .builder()
                    .httpStatus(FORBIDDEN)
                    .message("You have to specify at least one argument")
                    .build();
        }

        if((Long) joinPoint.getArgs()[0] == null  && (Principal) joinPoint.getArgs()[1] == null){
            throw new SecurityException("You have to specify at least one argument");
        }

    }

}
