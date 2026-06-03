package bo.gob.sigep.seg.usuarios.infrastructure.persistence.read;

import bo.gob.sigep.seg.usuarios.application.dto.UserResponse;
import bo.gob.sigep.seg.usuarios.application.dto.UserSummaryResponse;
import bo.gob.sigep.seg.usuarios.application.readmodel.UserReadRepository;
import bo.gob.sigep.seg.usuarios.infrastructure.persistence.repositories.UserJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class UserReadRepositoryImpl implements UserReadRepository {

    private final UserJpaRepository jpaRepository;

    public UserReadRepositoryImpl(UserJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public UserResponse findById(UUID id) {
        var entity = jpaRepository.findById(id).orElseThrow();
        return new UserResponse(
                entity.getId(),
                entity.getEmail(),
                entity.getName()
        );
    }

    @Override
    public List<UserSummaryResponse> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(entity -> new UserSummaryResponse(
                        entity.getId(),
                        entity.getEmail(),
                        entity.getName()
                ))
                .toList();
    }

}
