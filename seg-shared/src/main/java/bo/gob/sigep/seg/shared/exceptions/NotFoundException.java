package bo.gob.sigep.seg.shared.exceptions;

public class NotFoundException extends DomainException {

    public NotFoundException(String resource, String identifier) {
        super(String.format("%s no se encontró con el Identificador: %s", resource, identifier),
                "NOT_FOUND", "DOMAIN");
    }

    public NotFoundException(String resource, String identifier, Throwable cause) {
        super(
                String.format("%s no se encontró con el Identificador: %s", resource, identifier),
                "NOT_FOUND",
                "DOMAIN",
                cause
        );
    }
}