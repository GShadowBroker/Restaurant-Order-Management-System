package app.netlify.gledyson.restaurant.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomerOrderNotFoundException extends RuntimeException {
    public CustomerOrderNotFoundException(String message) {
        super(message);
    }
}
