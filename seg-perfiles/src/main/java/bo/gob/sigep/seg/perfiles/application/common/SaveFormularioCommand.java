package bo.gob.sigep.seg.perfiles.application.common;

import jakarta.validation.constraints.NotBlank;

public record SaveFormularioCommand (
        @NotBlank (message = "El código tipo de formulario es requerido")
        String codigoTipoFormulario,
        @NotBlank (message = "El Apellido paterno es requerido")
        String paterno,
        @NotBlank (message = "El Apellido materno es requerido")
        String materno,
        @NotBlank (message = "El nombre es requerido")
        String nombres,
        @NotBlank (message = "El nombre del Responsable es requerido")
        String responsableCreacion
){
}
