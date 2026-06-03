package bo.gob.sigep.seg.usuarios.application.usecases;

import bo.gob.sigep.seg.usuarios.application.dto.UserResponse;
import bo.gob.sigep.seg.usuarios.application.queries.GetUserByIdQuery;
import bo.gob.sigep.seg.usuarios.domain.models.User;
import bo.gob.sigep.seg.usuarios.domain.repositories.UserRepository;

public class GetUserByIdUseCase {

    private final UserRepository repository;

    public GetUserByIdUseCase(UserRepository repository) {
        this.repository = repository;
    }

    public UserResponse execute(GetUserByIdQuery query) {

        User user = repository.findById(query.id())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado")
        );

        return new UserResponse(
                user.getId(),
                user.getEmail().getValue(),
                user.getName().getValue()
        );
    }

}
