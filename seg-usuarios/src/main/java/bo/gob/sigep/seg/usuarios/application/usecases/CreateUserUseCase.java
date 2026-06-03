package bo.gob.sigep.seg.usuarios.application.usecases;

import bo.gob.sigep.seg.usuarios.domain.events.DomainEventPublisher;
import bo.gob.sigep.seg.usuarios.domain.events.UserCreatedEvent;
import bo.gob.sigep.seg.usuarios.domain.models.User;
import bo.gob.sigep.seg.usuarios.domain.models.valueobjects.Email;
import bo.gob.sigep.seg.usuarios.domain.models.valueobjects.PersonName;
import bo.gob.sigep.seg.usuarios.domain.repositories.UserRepository;
import bo.gob.sigep.seg.usuarios.domain.services.UserUniquenessChecker;

import java.util.UUID;

public class CreateUserUseCase {

    private final UserRepository userRepository;
    private final UserUniquenessChecker uniquenessChecker;
    private final DomainEventPublisher eventPublisher;

    public CreateUserUseCase(
            UserRepository userRepository,
            UserUniquenessChecker uniquenessChecker,
            DomainEventPublisher eventPublisher) {
        this.userRepository = userRepository;
        this.uniquenessChecker = uniquenessChecker;
        this.eventPublisher = eventPublisher;
    }

    public UUID execute(String email, String name) {

        // validamos email unico
        Email userEmail = new Email(email);
        uniquenessChecker.ensureEmailIsUnique(userEmail);

        // 1. Crear entidad de dominio
        User user = new User(
                UUID.randomUUID(),
                new Email(email),
                new PersonName(name)
        );

        // 2. Persistir usando puerto (NO implementación)
        userRepository.save(user);

        // Publicamos el evento
        eventPublisher.publish(
                new UserCreatedEvent(user.getId(), user.getEmail().getValue())
        );

        // 3. Retornar ID
        return user.getId();
    }

}
