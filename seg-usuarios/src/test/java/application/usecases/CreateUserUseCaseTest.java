package application.usecases;

import application.fakes.FakeDomainEventPublisher;
import application.fakes.InMemoryUserRepository;
import bo.gob.sigep.seg.usuarios.application.commands.CreateUserCommand;
import bo.gob.sigep.seg.usuarios.application.usecases.CreateUserUseCase;
import bo.gob.sigep.seg.usuarios.domain.services.UserUniquenessChecker;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CreateUserUseCaseTest {

    @Test
    void shouldCreateUser() {

        InMemoryUserRepository repository = new InMemoryUserRepository();
        FakeDomainEventPublisher publisher = new FakeDomainEventPublisher();

        UserUniquenessChecker checker =
                new UserUniquenessChecker(
                        repository
                );

        CreateUserUseCase useCase =
                new CreateUserUseCase(
                        repository,
                        checker,
                        publisher
                );

        UUID id = useCase.execute(
                new CreateUserCommand(
                        "juan@test.com",
                        "Juan Perez"
                )
        );

        assertNotNull(id);

        assertTrue(
                repository.findById(id)
                        .isPresent()
        );

        // Verificamos que se publicó un evento
        assertEquals(
                1,
                publisher.getEvents().size()
        );
    }


    @Test
    void shouldRejectDuplicatedEmail() {

        InMemoryUserRepository repository =
                new InMemoryUserRepository();

        FakeDomainEventPublisher publisher =
                new FakeDomainEventPublisher();

        UserUniquenessChecker checker =
                new UserUniquenessChecker(
                        repository
                );

        CreateUserUseCase useCase =
                new CreateUserUseCase(
                        repository,
                        checker,
                        publisher
                );

        useCase.execute(
                new CreateUserCommand(
                        "juan@test.com",
                        "Juan"
                )
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> useCase.execute(
                        new CreateUserCommand(
                                "juan@test.com",
                                "Otro"
                        )
                )
        );
    }
}
