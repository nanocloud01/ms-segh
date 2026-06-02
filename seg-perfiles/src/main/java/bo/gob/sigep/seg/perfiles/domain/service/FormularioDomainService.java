package bo.gob.sigep.seg.perfiles.domain.service;


import bo.gob.sigep.seg.perfiles.domain.model.Formulario;
import bo.gob.sigep.seg.perfiles.domain.repository.FormularioRepository;
import bo.gob.sigep.seg.shared.exceptions.ValidacionException;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@Component
public class FormularioDomainService {

    private final FormularioRepository formularioRepository;

    public FormularioDomainService(FormularioRepository formularioRepository) {
        if (formularioRepository == null) {
            throw new IllegalArgumentException("Repository no puede ser null");
        }
        this.formularioRepository = formularioRepository;
    }

    public void validarFormulario(Formulario formulario) {
        // Validaciones de registro a la Base de Datos existeTrazaUsuario
        validarRegistro(formulario);
    }

    //metodos de validacion privados
    private void validarRegistro(Formulario formulario) {
        if (formularioRepository.existeRegistro(formulario)) {
            throw new ValidacionException("El formulario del proceso ya fue registrado " + formulario.getCodigoProceso());
        }
    }

    public String generarCodigoProceso(String codigoTipoFormulario) {
        return  String.format("%04d", ThreadLocalRandom.current().nextInt(10000));
    }

}
