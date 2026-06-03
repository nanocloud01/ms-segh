package bo.gob.sigep.seg.usuarios.interfaces;

import bo.gob.sigep.seg.usuarios.domain.events.UserCreatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class UserCreatedListener {

    @EventListener
    public void handle(UserCreatedEvent event) {
        System.out.println("Usuario creado: "+ event.getEmail());
    }

}
