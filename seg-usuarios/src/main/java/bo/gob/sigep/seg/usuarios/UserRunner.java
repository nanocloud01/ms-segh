package bo.gob.sigep.seg.usuarios;

import bo.gob.sigep.seg.usuarios.application.usecases.CreateUserUseCase;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserRunner implements CommandLineRunner {

    private final CreateUserUseCase useCase;

    public UserRunner(CreateUserUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public void run(String... args) {
//        UUID id = useCase.execute("test@mail.com", "Juan");
//        System.out.println("Usuario creado: " + id);
    }

}
