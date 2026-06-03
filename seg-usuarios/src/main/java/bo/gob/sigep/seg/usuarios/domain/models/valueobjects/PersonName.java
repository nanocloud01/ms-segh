package bo.gob.sigep.seg.usuarios.domain.models.valueobjects;

import java.util.Objects;

public class PersonName {

    private final String value;

    public PersonName(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Nombre requerido");
        }
        if (value.length() < 3) {
            throw new IllegalArgumentException("Nombre demasiado corto");
        }
        this.value = value.trim();
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PersonName name)) {
            return false;
        }
        return Objects.equals(value, name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
