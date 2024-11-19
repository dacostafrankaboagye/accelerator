package frank.secureshop.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * Custom exception class for the Secure Shop application.
 * Encapsulates an error message and an HTTP status for better error handling.
 */
@Getter
@Setter
@Builder
public class SecureShopException extends RuntimeException {

    private final String message;
    private final HttpStatus httpStatus;

    /**
     * Constructs a new SecureShopException with the specified error message and HTTP status.
     *
     * @param message    the error message to be displayed
     * @param httpStatus the HTTP status associated with this exception
     */
    public SecureShopException(String message, HttpStatus httpStatus) {
        super(message);
        this.message = message;
        this.httpStatus = httpStatus;
    }

}
