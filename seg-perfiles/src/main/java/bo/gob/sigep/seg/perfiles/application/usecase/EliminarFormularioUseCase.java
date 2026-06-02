package bo.gob.sigep.seg.perfiles.application.usecase;

import bo.gob.sigep.seg.perfiles.application.service.IEliminarFormularioService;
import bo.gob.sigep.seg.perfiles.domain.model.Formulario;
import bo.gob.sigep.seg.perfiles.domain.repository.FormularioRepository;
import org.springframework.stereotype.Service;

@Service
public class EliminarFormularioUseCase implements IEliminarFormularioService {
    private final FormularioRepository formularioRepository;

    public EliminarFormularioUseCase(FormularioRepository formularioRepository) {
        this.formularioRepository = formularioRepository;
    }

    public void ejecutar(Long formularioId) {
        Formulario formulario = formularioRepository.findById(formularioId);
        formulario.eliminar();
        formularioRepository.save(formulario);
    }
}
