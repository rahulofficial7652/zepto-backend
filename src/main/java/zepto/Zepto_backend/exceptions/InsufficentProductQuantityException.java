package zepto.Zepto_backend.exceptions;

public class InsufficentProductQuantityException extends RuntimeException {
    public InsufficentProductQuantityException(String message) {
        super(message);
    }
}
