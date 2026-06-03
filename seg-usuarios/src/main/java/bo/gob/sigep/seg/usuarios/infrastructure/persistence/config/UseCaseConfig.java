package bo.gob.sigep.seg.usuarios.infrastructure.persistence.config;

import bo.gob.sigep.seg.usuarios.application.usecases.CreateUserUseCase;
import bo.gob.sigep.seg.usuarios.domain.repositories.UserRepository;
import bo.gob.sigep.seg.usuarios.domain.services.UserUniquenessChecker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public CreateUserUseCase createUserUseCase(UserRepository userRepository, UserUniquenessChecker uniquenessChecker) {
        return new CreateUserUseCase(userRepository, uniquenessChecker);
    }

    @Bean
    public UserUniquenessChecker userUniquenessChecker(UserRepository repository) {
        return new UserUniquenessChecker(repository);
    }

}
