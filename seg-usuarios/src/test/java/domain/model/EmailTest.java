package domain.model;

import bo.gob.sigep.seg.usuarios.domain.models.valueobjects.Email;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

    @Test
    void shouldCreateValidEmail() {

        Email email = new Email("juan@test.com");
        assertEquals(
                "juan@test.com",
                email.getValue()
        );
    }

    @Test
    void shouldThrowExceptionWhenEmailIsInvalid() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Email("correo-invalido")
        );
    }
}
