package bo.gob.sigep.seg.perfiles.application.usecase;

import bo.gob.sigep.seg.perfiles.application.common.FormularioResponse;
import bo.gob.sigep.seg.perfiles.application.common.SaveFormularioCommand;
import bo.gob.sigep.seg.perfiles.application.mapper.FormularioResponseMapper;
import bo.gob.sigep.seg.perfiles.application.service.IModificarFormularioService;
import bo.gob.sigep.seg.perfiles.domain.enums.AccionFormulario;
import bo.gob.sigep.seg.perfiles.domain.enums.EstadoFormulario;
import bo.gob.sigep.seg.perfiles.domain.model.Formulario;
import bo.gob.sigep.seg.perfiles.domain.repository.FormularioRepository;
import bo.gob.sigep.seg.shared.exceptions.ValidacionException;
import org.springframework.stereotype.Service;

@Service
public class ModificarFormularioUseCase implements IModificarFormularioService {
    private final FormularioRepository formularioRepository;
    private final FormularioResponseMapper formularioResponseMapper;

    public ModificarFormularioUseCase(FormularioRepository formularioRepository, FormularioResponseMapper formularioResponseMapper) {
        this.formularioRepository = formularioRepository;
        this.formularioResponseMapper = formularioResponseMapper;
    }

    public FormularioResponse ejecutar(Long codigoFormulario, SaveFormularioCommand command) {
        Formulario formulario = formularioRepository.findById(codigoFormulario);

        if (formulario.getEstado() != EstadoFormulario.ELABORADO) {
            throw new ValidacionException("El formulario debe estar en estado ELABORADO para ser modificado");
        }

        formulario.modificar(command.paterno(), command.materno(), command.nombres(), AccionFormulario.MODIFICAR);

        formulario = formularioRepository.save(formulario);
        return formularioResponseMapper.toResponse(formulario);
    }
}
