package bo.gob.sigep.seg.usuarios.infrastructure.events;

import bo.gob.sigep.seg.usuarios.domain.events.DomainEvent;
import bo.gob.sigep.seg.usuarios.domain.events.DomainEventPublisher;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class SpringDomainEventPublisher implements DomainEventPublisher {

    private final ApplicationEventPublisher publisher;

    public SpringDomainEventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public void publish(DomainEvent event) {
        publisher.publishEvent(event);
    }

}
