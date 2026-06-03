package bo.gob.sigep.seg.usuarios.domain.repositories;

import bo.gob.sigep.seg.usuarios.domain.models.User;
import bo.gob.sigep.seg.usuarios.domain.models.valueobjects.Email;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository {

    void save(User user);

    Optional<User> findById(UUID id);

    boolean existsByEmail(Email email);

}
