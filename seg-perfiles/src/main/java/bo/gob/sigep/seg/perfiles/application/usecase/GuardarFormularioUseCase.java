package bo.gob.sigep.seg.perfiles.application.usecase;

import bo.gob.sigep.seg.perfiles.application.common.FormularioResponse;
import bo.gob.sigep.seg.perfiles.application.common.SaveFormularioCommand;
import bo.gob.sigep.seg.perfiles.application.mapper.FormularioResponseMapper;
import bo.gob.sigep.seg.perfiles.application.service.IGuardarFormularioService;
import bo.gob.sigep.seg.perfiles.domain.model.Formulario;
import bo.gob.sigep.seg.perfiles.domain.repository.FormularioRepository;
import bo.gob.sigep.seg.perfiles.domain.service.FormularioDomainService;
import org.springframework.stereotype.Service;

@Service
public class GuardarFormularioUseCase implements IGuardarFormularioService {

    private final FormularioRepository formularioRepository;
    private final FormularioDomainService formularioDomainService;
    private final FormularioResponseMapper formularioResponseMapper;

    public GuardarFormularioUseCase(
            FormularioRepository formularioRepository,
            FormularioDomainService formularioDomainService,
            FormularioResponseMapper formularioResponseMapper) {
        this.formularioRepository = formularioRepository;
        this.formularioDomainService = formularioDomainService;
        this.formularioResponseMapper = formularioResponseMapper;
    }

    public FormularioResponse ejecutar(SaveFormularioCommand saveFormularioCommand) {
        String codigoProceso = formularioDomainService.generarCodigoProceso(saveFormularioCommand.codigoTipoFormulario());
        Formulario formulario = Formulario.crear(
                saveFormularioCommand.codigoTipoFormulario(),
                saveFormularioCommand.paterno(), saveFormularioCommand.materno(),
                saveFormularioCommand.nombres(), codigoProceso,
                saveFormularioCommand.responsableCreacion()
        );
        formularioDomainService.validarFormulario(formulario);
        formulario = formularioRepository.save(formulario);
        return formularioResponseMapper.toResponse(formulario);
    }
}
