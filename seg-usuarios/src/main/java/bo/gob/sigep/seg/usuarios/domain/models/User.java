package bo.gob.sigep.seg.usuarios.domain.models;

import java.util.Objects;
import java.util.UUID;

public class User {

    private final UUID id;
    private final String email;
    private final String name;

    public User(UUID id, String email, String name) {
        if (id == null) {
            throw new IllegalArgumentException("id no puede ser null");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("email inválido");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name inválido");
        }

        this.id = id;
        this.email = email;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
