package domain.model;

import bo.gob.sigep.seg.usuarios.domain.models.User;
import bo.gob.sigep.seg.usuarios.domain.models.valueobjects.Email;
import bo.gob.sigep.seg.usuarios.domain.repositories.UserRepository;

import java.util.*;

public class FakeUserRepository implements UserRepository {

    private boolean exists;

    public void setExists(boolean exists) {
        this.exists = exists;
    }

    @Override
    public boolean existsByEmail(Email email) {
        return exists;
    }

    @Override
    public void save(User user) {
    }

    @Override
    public Optional<User> findById(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        return List.of();
    }

}
