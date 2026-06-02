package bo.gob.sigep.seg.perfiles.application.common;


import jakarta.validation.constraints.NotNull;

public record FormularioIdRequest(
        @NotNull(message = "El código es requerido")
        Long codigoFormulario
) {
}
