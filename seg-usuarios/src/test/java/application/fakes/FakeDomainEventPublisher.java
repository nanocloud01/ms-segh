package application.fakes;

import bo.gob.sigep.seg.usuarios.domain.events.DomainEvent;
import bo.gob.sigep.seg.usuarios.domain.events.DomainEventPublisher;

import java.util.ArrayList;
import java.util.List;

public class FakeDomainEventPublisher implements DomainEventPublisher {

    private final List<DomainEvent> events = new ArrayList<>();

    @Override
    public void publish(DomainEvent event) {
        events.add(event);
    }

    public List<DomainEvent> getEvents() {
        return events;
    }
}
