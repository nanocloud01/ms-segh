package bo.gob.sigep.seg.perfiles.application.service;

import bo.gob.sigep.seg.perfiles.application.common.FormularioResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IObtenerFormularioService {
    FormularioResponse ejecutar(Long codigoFormulario);
    List<FormularioResponse> ejecutar2();
    Page<FormularioResponse> ejecutar3(String paterno, Pageable pageable);
}
