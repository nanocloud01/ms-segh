package bo.gob.sigep.seg.usuarios.application.usecases;

import bo.gob.sigep.seg.usuarios.application.dto.UserResponse;
import bo.gob.sigep.seg.usuarios.application.queries.GetUserByIdQuery;
import bo.gob.sigep.seg.usuarios.application.readmodel.UserReadRepository;
import bo.gob.sigep.seg.usuarios.domain.models.User;
import bo.gob.sigep.seg.usuarios.domain.repositories.UserRepository;

public class GetUserByIdUseCase {

    private final UserReadRepository repository;

    public GetUserByIdUseCase(UserReadRepository repository) {
        this.repository = repository;
    }

    public UserResponse execute(GetUserByIdQuery query) {
        return repository.findById(query.id());
    }

}
