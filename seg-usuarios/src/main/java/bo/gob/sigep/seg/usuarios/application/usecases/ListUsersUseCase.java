package bo.gob.sigep.seg.usuarios.application.usecases;

import bo.gob.sigep.seg.usuarios.application.dto.UserSummaryResponse;
import bo.gob.sigep.seg.usuarios.application.queries.ListUsersQuery;
import bo.gob.sigep.seg.usuarios.application.readmodel.UserReadRepository;
import bo.gob.sigep.seg.usuarios.domain.repositories.UserRepository;

import java.util.List;

public class ListUsersUseCase {

    private final UserReadRepository repository;

    public ListUsersUseCase(UserReadRepository repository) {
        this.repository = repository;
    }

    public List<UserSummaryResponse> execute(ListUsersQuery query) {
        return repository.findAll();
    }

}
