package bo.gob.sigep.seg.perfiles.domain.repository;

import bo.gob.sigep.seg.perfiles.domain.model.Formulario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface FormularioRepository {
    Formulario save(Formulario formulario);
    Formulario findById(Long id);
    List<Formulario> findAll();
    Page<Formulario> findAllByPaterno(String paterno, Pageable pageable);
    void deleteById(Long id);
    boolean existsById(Long id);
    boolean existeRegistro(Formulario formulario);
}
