package app.netlify.gledyson.restaurant.exception;

public class CustomerOrderNotFoundException extends RuntimeException {
    public CustomerOrderNotFoundException(String message) {
        super(message);
    }
}
