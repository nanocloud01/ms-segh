package bo.gob.sigep.seg.usuarios.application.usecases;

import bo.gob.sigep.seg.usuarios.domain.models.User;
import bo.gob.sigep.seg.usuarios.domain.repositories.UserRepository;

import java.util.UUID;

public class CreateUserUseCase {

    private final UserRepository userRepository;

    public CreateUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UUID execute(String email, String name) {

        // 1. Crear entidad de dominio
        User user = new User(
                UUID.randomUUID(),
                email,
                name
        );

        // 2. Persistir usando puerto (NO implementación)
        userRepository.save(user);

        // 3. Retornar ID
        return user.getId();
    }

}
