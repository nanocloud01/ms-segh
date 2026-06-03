package domain.model;

import bo.gob.sigep.seg.usuarios.domain.models.valueobjects.Email;
import bo.gob.sigep.seg.usuarios.domain.services.UserUniquenessChecker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserUniquenessCheckerTest {

    @Test
    void shouldThrowExceptionWhenEmailAlreadyExists() {

        FakeUserRepository repository = new FakeUserRepository();

        repository.setExists(true);

        UserUniquenessChecker checker = new UserUniquenessChecker(repository);

        assertThrows(
                IllegalArgumentException.class,
                () -> checker.ensureEmailIsUnique(
                        new Email("test@mail.com")
                )
        );
    }
}
