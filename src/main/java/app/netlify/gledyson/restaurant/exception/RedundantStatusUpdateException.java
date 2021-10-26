package app.netlify.gledyson.restaurant.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RedundantStatusUpdateException extends RuntimeException {
    public RedundantStatusUpdateException(String message) {
        super(message);
    }
}
