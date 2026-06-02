package bo.gob.sigep.seg.perfiles.domain.repository;

import bo.gob.sigep.seg.perfiles.domain.enums.EstadoFormulario;
import bo.gob.sigep.seg.perfiles.domain.model.Formulario;

import java.util.List;

public interface FormularioQueryRepository {
    List<Formulario> findAll();
    List<Formulario> findByEstado(EstadoFormulario estado);
    List<Formulario> findByGestion(String gestion);
    List<Formulario> findByCodigoProceso(String codigoProceso);
    List<Formulario> buscarPorNombre(String nombre);
}
