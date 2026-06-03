package bo.gob.sigep.seg.usuarios.infrastructure.persistence.repositories;

import bo.gob.sigep.seg.usuarios.infrastructure.persistence.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserJpaRepository extends JpaRepository<UserEntity, UUID> {

    boolean existsByEmail(String email);

}
