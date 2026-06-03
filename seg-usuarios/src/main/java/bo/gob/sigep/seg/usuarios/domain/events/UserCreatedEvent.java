package bo.gob.sigep.seg.usuarios.domain.events;

import java.time.LocalDateTime;
import java.util.UUID;

public class UserCreatedEvent implements DomainEvent {

    private final UUID userId;
    private final String email;
    private final LocalDateTime occurredOn;

    public UserCreatedEvent(UUID userId, String email) {
        this.userId = userId;
        this.email = email;
        this.occurredOn = LocalDateTime.now();
    }

    @Override
    public LocalDateTime occurredOn() {
        return occurredOn;
    }

    public UUID getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

}
