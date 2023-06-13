package ma.lbv.api.commonparent.exceptions.technical;

public class MissingIdException extends TechnicalException {

    public MissingIdException(String message) {
        super("ID_IS_MISSING"+message);

    }

}
