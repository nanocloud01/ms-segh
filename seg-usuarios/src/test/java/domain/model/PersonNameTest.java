package domain.model;

import bo.gob.sigep.seg.usuarios.domain.models.valueobjects.PersonName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonNameTest {

    @Test
    void shouldCreateValidName() {
        PersonName name = new PersonName("Juan Perez");
        assertEquals(
                "Juan Perez",
                name.getValue()
        );
    }

    @Test
    void shouldRejectShortName() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new PersonName("AB")
        );
    }
}
