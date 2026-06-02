package bo.gob.sigep.seg.perfiles.application.usecase;

import bo.gob.sigep.seg.perfiles.application.common.FormularioIdRequest;
import bo.gob.sigep.seg.perfiles.application.service.IPublicacionProcesoService;
import bo.gob.sigep.seg.perfiles.domain.enums.EstadoFormulario;
import bo.gob.sigep.seg.perfiles.domain.model.Formulario;
import bo.gob.sigep.seg.perfiles.domain.repository.FormularioRepository;
import bo.gob.sigep.seg.perfiles.domain.service.FormularioDomainService;
import bo.gob.sigep.seg.shared.exceptions.ValidacionException;
import org.springframework.stereotype.Service;

@Service
public class PublicacionProcesoUseCase implements IPublicacionProcesoService {
    private final FormularioRepository formularioRepository;
    private final FormularioDomainService formularioDomainService;

    public PublicacionProcesoUseCase(FormularioRepository formularioRepository, FormularioDomainService formularioDomainService) {
        this.formularioRepository = formularioRepository;
        this.formularioDomainService = formularioDomainService;
    }

    public void ejecutar(FormularioIdRequest formularioId) {
        Formulario formulario = formularioRepository.findById(formularioId.codigoFormulario());
        if (formulario.getEstado() != EstadoFormulario.ELABORADO) {
            throw new ValidacionException("El formulario debe estar en estado ELABORADO para ser publicado");
        }

        formularioDomainService.validarFormulario(formulario);
        formularioRepository.save(formulario);
    }
}
