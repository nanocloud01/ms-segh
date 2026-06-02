package bo.gob.sigep.seg.perfiles.domain.maquinaestados;



import bo.gob.sigep.seg.perfiles.domain.enums.AccionFormulario;
import bo.gob.sigep.seg.perfiles.domain.enums.EstadoFormulario;
import bo.gob.sigep.seg.shared.maquinaestados.MaquinaEstado;

import java.util.Map;

public class FormularioValidacionEstado {
    public static final MaquinaEstado<EstadoFormulario, AccionFormulario> INSTANCE =
            new MaquinaEstado<>(
                    Map.of(
                            EstadoFormulario.INICIAL, Map.of(
                                    AccionFormulario.CREAR, EstadoFormulario.ELABORADO
                            ),
                            EstadoFormulario.ELABORADO, Map.of(
                                    AccionFormulario.MODIFICAR, EstadoFormulario.ELABORADO,
                                    AccionFormulario.ELIMINAR, EstadoFormulario.FINAL
                            ),
                            EstadoFormulario.FINAL, Map.of()
                    )
            );

    private FormularioValidacionEstado() {
    }
}
