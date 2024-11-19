package frank.secureshop.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Global exception handler for the Secure Shop application.
 * Catches and handles exceptions thrown throughout the application, providing consistent error responses.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles exceptions of type {@link SecureShopException}.
     *
     * @param e the exception to handle
     * @return a response entity containing the error message and HTTP status
     */
    @ExceptionHandler(SecureShopException.class)
    public ResponseEntity<?> handleCustomException(SecureShopException e){
        return ResponseEntity
                .status(e.getHttpStatus())
                .body(e.getMessage());
    }
}
