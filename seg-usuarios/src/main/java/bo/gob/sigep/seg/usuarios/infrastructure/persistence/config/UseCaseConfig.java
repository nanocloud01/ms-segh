package bo.gob.sigep.seg.usuarios.infrastructure.persistence.config;

import bo.gob.sigep.seg.usuarios.application.readmodel.UserReadRepository;
import bo.gob.sigep.seg.usuarios.application.usecases.CreateUserUseCase;
import bo.gob.sigep.seg.usuarios.application.usecases.GetUserByIdUseCase;
import bo.gob.sigep.seg.usuarios.application.usecases.ListUsersUseCase;
import bo.gob.sigep.seg.usuarios.domain.events.DomainEventPublisher;
import bo.gob.sigep.seg.usuarios.domain.repositories.UserRepository;
import bo.gob.sigep.seg.usuarios.domain.services.UserUniquenessChecker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public CreateUserUseCase createUserUseCase(
            UserRepository repository,
            UserUniquenessChecker uniquenessChecker,
            DomainEventPublisher eventPublisher
    ) {
        return new CreateUserUseCase(
                repository,
                uniquenessChecker,
                eventPublisher
        );
    }

    @Bean
    public UserUniquenessChecker userUniquenessChecker(UserRepository repository) {
        return new UserUniquenessChecker(repository);
    }

    @Bean
    public GetUserByIdUseCase getUserByIdUseCase(UserReadRepository repository) {
        return new GetUserByIdUseCase(repository);
    }

    @Bean
    public ListUsersUseCase listUsersUseCase(UserReadRepository repository) {
        return new ListUsersUseCase(repository);
    }

}
