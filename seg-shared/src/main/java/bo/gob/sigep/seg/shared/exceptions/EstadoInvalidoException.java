package bo.gob.sigep.seg.shared.exceptions;

public class EstadoInvalidoException extends RuntimeException{
    public EstadoInvalidoException(Object state, Object action) {
        super("Acción " + action + " no válida para el estado " + state);
    }
}
