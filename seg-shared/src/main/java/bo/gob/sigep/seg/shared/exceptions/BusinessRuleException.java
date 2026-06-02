package bo.gob.sigep.seg.shared.exceptions;

public class BusinessRuleException extends DomainException {
    public BusinessRuleException(String message, String errorCode, String module) {
        super(message, errorCode, module);
    }
}