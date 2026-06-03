package bo.gob.sigep.seg.usuarios.application.usecases;

import bo.gob.sigep.seg.usuarios.domain.models.User;
import bo.gob.sigep.seg.usuarios.domain.models.valueobjects.Email;
import bo.gob.sigep.seg.usuarios.domain.models.valueobjects.PersonName;
import bo.gob.sigep.seg.usuarios.domain.repositories.UserRepository;
import bo.gob.sigep.seg.usuarios.domain.services.UserUniquenessChecker;

import java.util.UUID;

public class CreateUserUseCase {

    private final UserRepository userRepository;
    private final UserUniquenessChecker uniquenessChecker;

    public CreateUserUseCase(UserRepository userRepository, UserUniquenessChecker uniquenessChecker) {
        this.userRepository = userRepository;
        this.uniquenessChecker = uniquenessChecker;
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

        // 3. Retornar ID
        return user.getId();
    }

}
