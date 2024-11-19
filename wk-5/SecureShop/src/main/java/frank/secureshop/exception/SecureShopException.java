package frank.secureshop.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@Builder
public class SecureShopException extends RuntimeException {

    private final String message;
    private final HttpStatus httpStatus;

    public SecureShopException(String message, HttpStatus httpStatus) {
        super(message);
        this.message = message;
        this.httpStatus = httpStatus;
    }

}
