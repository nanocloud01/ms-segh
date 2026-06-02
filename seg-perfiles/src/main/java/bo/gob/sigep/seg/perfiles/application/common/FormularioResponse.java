package bo.gob.sigep.seg.perfiles.application.common;

import java.time.LocalDate;

public record FormularioResponse (
         Long codigoFormulario,
         String codigoTipoFormulario,
         String paterno,
         String materno,
         String nombres,
         String codigoProceso,
         String responsableCreacion,
         LocalDate fechaCreacion,
         int gestion
){
    
}
