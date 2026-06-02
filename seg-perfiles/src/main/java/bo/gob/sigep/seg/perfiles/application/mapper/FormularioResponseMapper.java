package bo.gob.sigep.seg.perfiles.application.mapper;

import bo.gob.sigep.seg.perfiles.application.common.FormularioResponse;
import bo.gob.sigep.seg.perfiles.domain.model.Formulario;
import org.springframework.stereotype.Component;

@Component
public class FormularioResponseMapper {

    public FormularioResponse toResponse(Formulario formulario) {
        if (formulario == null) {
            return null;
        }
        return new FormularioResponse(
                formulario.getCodigoFormulario(),
                formulario.getCodigoTipoFormulario(),
                formulario.getPaterno(),
                formulario.getMaterno(),
                formulario.getNombres(),
                formulario.getCodigoProceso(),
                formulario.getResponsableCreacion(),
                formulario.getFechaCreacion(),
                formulario.getGestion()
        );
    }
}
