package bo.gob.sigep.seg.usuarios.application.usecases;

import bo.gob.sigep.seg.usuarios.application.dto.UserSummaryResponse;
import bo.gob.sigep.seg.usuarios.application.queries.ListUsersQuery;
import bo.gob.sigep.seg.usuarios.domain.repositories.UserRepository;

import java.util.List;

public class ListUsersUseCase {

    private final UserRepository repository;

    public ListUsersUseCase(UserRepository repository) {
        this.repository = repository;
    }

    public List<UserSummaryResponse> execute(ListUsersQuery query) {
        return repository.findAll()
                .stream()
                .map(user -> new UserSummaryResponse(
                        user.getId(),
                        user.getEmail().getValue(),
                        user.getName().getValue()
                ))
                .toList();
    }

}
