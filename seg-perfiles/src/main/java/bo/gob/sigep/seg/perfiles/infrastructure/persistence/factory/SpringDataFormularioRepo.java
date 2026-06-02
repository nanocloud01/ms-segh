package bo.gob.sigep.seg.perfiles.infrastructure.persistence.factory;

import bo.gob.sigep.seg.perfiles.infrastructure.persistence.entity.FormulariosEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataFormularioRepo extends JpaRepository<FormulariosEntity, Long> {

    @Query("SELECT p FROM FormulariosEntity p WHERE " +
            "(:paterno IS NULL OR LOWER(p.paterno) LIKE LOWER(CONCAT('%', :paterno, '%')))")
    Page<FormulariosEntity> buscarConFiltro(String paterno, Pageable pageable);

}
