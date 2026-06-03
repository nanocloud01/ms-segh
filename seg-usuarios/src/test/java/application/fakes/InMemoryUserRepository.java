package application.fakes;

import bo.gob.sigep.seg.usuarios.domain.models.User;
import bo.gob.sigep.seg.usuarios.domain.models.valueobjects.Email;
import bo.gob.sigep.seg.usuarios.domain.repositories.UserRepository;

import java.util.*;

public class InMemoryUserRepository implements UserRepository {

    private final Map<UUID, User> users =
            new HashMap<>();

    @Override
    public void save(
            User user
    ) {
        users.put(
                user.getId(),
                user
        );
    }

    @Override
    public Optional<User> findById(
            UUID id
    ) {
        return Optional.ofNullable(
                users.get(id)
        );
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(
                users.values()
        );
    }

    @Override
    public boolean existsByEmail(
            Email email
    ) {

        return users.values()
                .stream()
                .anyMatch(user ->
                        user.getEmail()
                                .equals(email));
    }
}
