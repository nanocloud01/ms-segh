package bo.gob.sigep.seg.shared.exceptions;

public class ValidacionException extends DomainException {

    public ValidacionException(String message) {
        super(message, "VALIDATION_ERROR", "DOMAIN");
    }

    public ValidacionException(String message, Throwable cause) {
        super(message, "VALIDATION_ERROR", "DOMAIN", cause);
    }

    public ValidacionException(String message, String errorCode, String module){
        super(message, errorCode, module);
    }
}