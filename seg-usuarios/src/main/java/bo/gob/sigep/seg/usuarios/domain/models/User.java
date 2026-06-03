package bo.gob.sigep.seg.usuarios.domain.models;

import bo.gob.sigep.seg.usuarios.domain.models.valueobjects.Email;
import bo.gob.sigep.seg.usuarios.domain.models.valueobjects.PersonName;

import java.util.Objects;
import java.util.UUID;

public class User {

    private final UUID id;
    private final Email email;
    private final PersonName name;

    public User(UUID id, Email email, PersonName name) {
        if (id == null) {
            throw new IllegalArgumentException("Id requerido");
        }
        this.id = id;
        this.email = email;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public Email getEmail() {
        return email;
    }

    public PersonName getName() {
        return name;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        }
//        if (!(o instanceof User)) {
//            return false;
//        }
//        User user = (User) o;
//        return id.equals(user.id);
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User user)) {
            return false;
        }
        return Objects.equals(id, user.id);
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(id);
//    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
