package bo.gob.sigep.seg.usuarios.infrastructure.persistence.adapters;

import bo.gob.sigep.seg.usuarios.domain.models.User;
import bo.gob.sigep.seg.usuarios.domain.repositories.UserRepository;
import bo.gob.sigep.seg.usuarios.infrastructure.persistence.entities.UserEntity;
import bo.gob.sigep.seg.usuarios.infrastructure.persistence.repositories.UserJpaRepository;
import org.springframework.stereotype.Repository;

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
                user.getEmail(),
                user.getName()
        );

        jpaRepository.save(entity);
    }

    @Override
    public Optional<User> findById(UUID id) {
        return jpaRepository.findById(id)
                .map(entity -> new User(
                        entity.getId(),
                        entity.getEmail(),
                        entity.getName()
                ));
    }

}
