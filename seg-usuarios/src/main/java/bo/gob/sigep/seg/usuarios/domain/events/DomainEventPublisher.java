package bo.gob.sigep.seg.usuarios.domain.events;

public interface DomainEventPublisher {

    void publish(DomainEvent event);

}
