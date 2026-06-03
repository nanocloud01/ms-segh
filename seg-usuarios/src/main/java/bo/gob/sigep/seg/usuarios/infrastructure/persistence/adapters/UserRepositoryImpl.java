package bo.gob.sigep.seg.usuarios.infrastructure.persistence.adapters;

import bo.gob.sigep.seg.usuarios.domain.models.User;
import bo.gob.sigep.seg.usuarios.domain.models.valueobjects.Email;
import bo.gob.sigep.seg.usuarios.domain.models.valueobjects.PersonName;
import bo.gob.sigep.seg.usuarios.domain.repositories.UserRepository;
import bo.gob.sigep.seg.usuarios.infrastructure.persistence.entities.UserEntity;
import bo.gob.sigep.seg.usuarios.infrastructure.persistence.repositories.UserJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final UserJpaRepository jpaRepository;

    public UserRepositoryImpl(UserJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public void save(User user) {
        UserEntity entity = new UserEntity(
                user.getId(),
                user.getEmail().getValue(),
                user.getName().getValue()
        );

        jpaRepository.save(entity);
    }

    @Override
    public Optional<User> findById(UUID id) {
        return jpaRepository.findById(id)
                .map(entity -> new User(
                        entity.getId(),
                        new Email(entity.getEmail()),
                        new PersonName(entity.getName())
                ));
    }

    @Override
    public boolean existsByEmail(Email email) {
        return jpaRepository.existsByEmail(email.getValue());
    }

    @Override
    public List<User> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(entity -> new User(
                        entity.getId(),
                        new Email(entity.getEmail()),
                        new PersonName(entity.getName())
                ))
                .toList();
    }

}
