package bo.gob.sigep.seg.shared.maquinaestados;



import bo.gob.sigep.seg.shared.exceptions.EstadoInvalidoException;

import java.util.Map;

public class MaquinaEstado<S, A> {

    private final Map<S, Map<A, S>> transitions;

    public MaquinaEstado(Map<S, Map<A, S>> transitions) {
        this.transitions = Map.copyOf(transitions);
    }

    public S next(S currentState, A action) {

        Map<A, S> actions = transitions.get(currentState);

        if (actions == null || !actions.containsKey(action)) {
            throw new EstadoInvalidoException(currentState, action);
        }

        return actions.get(action);
    }
}

