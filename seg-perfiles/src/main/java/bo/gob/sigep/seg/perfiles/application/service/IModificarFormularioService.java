package bo.gob.sigep.seg.perfiles.application.service;

import bo.gob.sigep.seg.perfiles.application.common.FormularioResponse;
import bo.gob.sigep.seg.perfiles.application.common.SaveFormularioCommand;

public interface IModificarFormularioService {
    FormularioResponse ejecutar(Long codigoFormulario, SaveFormularioCommand command);
}
