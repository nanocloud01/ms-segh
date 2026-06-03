package bo.gob.sigep.seg.usuarios.domain.models.valueobjects;

import java.util.Objects;

public class Email {

    private final String value;

    public Email(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Email requerido");
        }
        if (!value.contains("@")) {
            throw new IllegalArgumentException("Formato de email inválido");
        }
        this.value = value.toLowerCase().trim();
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Email email)) {
            return false;
        }
        return Objects.equals(value, email.value);
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
