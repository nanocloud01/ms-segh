package bo.gob.sigep.seg.shared.exceptions;

public class EsadoInvalidoException extends RuntimeException{
    public EsadoInvalidoException(Object state, Object action) {
        super("Acción " + action + " no válida para el estado " + state);
    }
}
