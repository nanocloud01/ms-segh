package bo.gob.sigep.seg.perfiles.infrastructure.persistence.mapper;

import bo.gob.sigep.seg.perfiles.domain.enums.EstadoFormulario;
import bo.gob.sigep.seg.perfiles.domain.model.Formulario;
import bo.gob.sigep.seg.perfiles.infrastructure.persistence.entity.FormulariosEntity;
import org.springframework.stereotype.Component;

@Component
public class FormularioEntityMapper {

    public FormulariosEntity toEntity(Formulario formulario){
        if (formulario == null) {
            return null;
        }

        FormulariosEntity entity = new FormulariosEntity();
        entity.setCodigoFormulario(formulario.getCodigoFormulario());
        entity.setCodigoTipoFormulario(formulario.getCodigoTipoFormulario());
        entity.setPaterno(formulario.getPaterno());
        entity.setMaterno(formulario.getMaterno());
        entity.setNombres(formulario.getNombres());
        entity.setCodigoProceso(formulario.getCodigoProceso());
        entity.setResponsableCreacion(formulario.getResponsableCreacion());
        entity.setFechaCreacion(formulario.getFechaCreacion());
        entity.setGestion(formulario.getGestion());
        entity.setEstado(formulario.getEstado().name());

        return entity;
    }
    public Formulario toDomain(FormulariosEntity entity){
        if (entity == null) {
            return null;
        }

        return Formulario.reconstruir(
                entity.getCodigoFormulario(),
                entity.getCodigoTipoFormulario(),
                entity.getPaterno(),
                entity.getMaterno(),
                entity.getNombres(),
                entity.getCodigoProceso(),
                entity.getResponsableCreacion(),
                entity.getFechaCreacion(),
                entity.getGestion(),
                EstadoFormulario.valueOf(entity.getEstado())
        );
    }
}
