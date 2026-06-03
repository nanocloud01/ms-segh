package bo.gob.sigep.seg.usuarios.domain.events;

import java.time.LocalDateTime;

public interface DomainEvent {

    LocalDateTime occurredOn();

}
