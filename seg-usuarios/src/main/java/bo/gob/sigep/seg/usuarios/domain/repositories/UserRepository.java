package bo.gob.sigep.seg.usuarios.domain.repositories;

import bo.gob.sigep.seg.usuarios.domain.models.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository {

    void save(User user);

    Optional<User> findById(UUID id);

}
