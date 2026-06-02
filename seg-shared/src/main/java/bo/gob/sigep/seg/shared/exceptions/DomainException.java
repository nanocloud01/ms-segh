package bo.gob.sigep.seg.shared.exceptions;

public abstract class DomainException extends RuntimeException {

    private final String errorCode;
    private final String module;

    protected DomainException(String message, String errorCode, String module) {
        super(message);
        this.errorCode = errorCode;
        this.module = module;
    }

    protected DomainException(String message, String errorCode, String module, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
        this.module = module;
    }

    public String getErrorCode() {
        return errorCode;
    }
    public String getModule() {
        return module;
    }
}