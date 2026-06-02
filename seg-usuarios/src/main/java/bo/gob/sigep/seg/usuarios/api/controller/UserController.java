package bo.gob.sigep.seg.usuarios.api.controller;

import bo.gob.sigep.seg.usuarios.api.dto.CreateUserRequest;
import bo.gob.sigep.seg.usuarios.api.dto.CreateUserResponse;
import bo.gob.sigep.seg.usuarios.application.usecases.CreateUserUseCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private final CreateUserUseCase createUserUseCase;

    public UserController(CreateUserUseCase createUserUseCase) {
        this.createUserUseCase = createUserUseCase;
    }

    @PostMapping
    public CreateUserResponse create(@RequestBody CreateUserRequest request) {

        UUID id = createUserUseCase.execute(
                request.email(),
                request.name()
        );

        return new CreateUserResponse(id);
    }
}
