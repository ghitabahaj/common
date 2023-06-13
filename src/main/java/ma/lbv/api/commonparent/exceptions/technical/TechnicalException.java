package ma.lbv.api.commonparent.exceptions.technical;

public class TechnicalException extends RuntimeException{

    public TechnicalException(String message) {
        super(message);
    }

    public TechnicalException(String message, Throwable cause) {
        super(message, cause);
    }
}
