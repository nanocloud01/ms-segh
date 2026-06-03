package bo.gob.sigep.seg.usuarios.api.controller;

import bo.gob.sigep.seg.usuarios.api.dto.CreateUserRequest;
import bo.gob.sigep.seg.usuarios.api.dto.CreateUserResponse;
import bo.gob.sigep.seg.usuarios.application.commands.CreateUserCommand;
import bo.gob.sigep.seg.usuarios.application.dto.UserResponse;
import bo.gob.sigep.seg.usuarios.application.dto.UserSummaryResponse;
import bo.gob.sigep.seg.usuarios.application.queries.GetUserByIdQuery;
import bo.gob.sigep.seg.usuarios.application.queries.ListUsersQuery;
import bo.gob.sigep.seg.usuarios.application.usecases.CreateUserUseCase;
import bo.gob.sigep.seg.usuarios.application.usecases.GetUserByIdUseCase;
import bo.gob.sigep.seg.usuarios.application.usecases.ListUsersUseCase;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private final CreateUserUseCase createUserUseCase;
    private final GetUserByIdUseCase getUserByIdUseCase;
    private final ListUsersUseCase listUsersUseCase;

    public UserController(CreateUserUseCase createUserUseCase, GetUserByIdUseCase getUserByIdUseCase, ListUsersUseCase listUsersUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.getUserByIdUseCase = getUserByIdUseCase;
        this.listUsersUseCase = listUsersUseCase;
    }

    @PostMapping
    public CreateUserResponse create(@RequestBody CreateUserRequest request) {

        CreateUserCommand command = new CreateUserCommand(
                request.email(),
                request.name()
        );
        UUID id = createUserUseCase.execute(command);
        return new CreateUserResponse(id);
    }

    @GetMapping("/{id}")
    public UserResponse getById(@PathVariable UUID id) {
        return getUserByIdUseCase.execute(new GetUserByIdQuery(id));
    }

    @GetMapping
    public List<UserSummaryResponse> findAll() {
        return listUsersUseCase.execute(new ListUsersQuery());
    }

}
