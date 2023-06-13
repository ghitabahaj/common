package ma.lbv.api.commonparent.exceptions.business;

public class InvalidArgumentException extends BusinessException {

    public InvalidArgumentException(String message) {
        super(message);
    }

    public InvalidArgumentException(String message, Throwable cause) {
        super(message, cause);
    }
}