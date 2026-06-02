package bo.gob.sigep.seg.perfiles.application.usecase;

import bo.gob.sigep.seg.perfiles.application.common.FormularioResponse;
import bo.gob.sigep.seg.perfiles.application.mapper.FormularioResponseMapper;
import bo.gob.sigep.seg.perfiles.application.service.IObtenerFormularioService;
import bo.gob.sigep.seg.perfiles.domain.model.Formulario;
import bo.gob.sigep.seg.perfiles.domain.repository.FormularioRepository;
import org.mefp.core.logs.LogManager;
import org.mefp.core.logs.UtilString;
import org.slf4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObtenerFormProcesoUseCase implements IObtenerFormularioService {

    private static final Logger logSigep = LogManager.getLogger("perfiles", "mi-modulito");

    private final FormularioRepository formularioRepository;
    private final FormularioResponseMapper formularioResponseMapper;

    public ObtenerFormProcesoUseCase(FormularioRepository formularioRepository, FormularioResponseMapper formularioResponseMapper) {
        this.formularioRepository = formularioRepository;
        this.formularioResponseMapper = formularioResponseMapper;
    }

    public FormularioResponse ejecutar(Long codigoFormulario) {

        System.out.println("codigoFormulario APPLICATION: " + codigoFormulario);
        String test = "pruebita bonita APPLICATION";
        System.out.println(test + " APPLICATION es -> " + UtilString.upper(test));

        logSigep.info("into ObtenerFormProcesoUseCase in perfiles module---------------------");

        Formulario formulario = formularioRepository.findById(codigoFormulario);
        return formularioResponseMapper.toResponse(formulario);
    }

    public List<FormularioResponse> ejecutar2() {
        List<Formulario> formularios = formularioRepository.findAll();
        return formularios.stream().map(formularioResponseMapper::toResponse).toList();
    }

    @Override
    public Page<FormularioResponse> ejecutar3(String paterno, Pageable pageable) {
        Page<Formulario> formularios = formularioRepository.findAllByPaterno(paterno, pageable);
        return formularios.map(formularioResponseMapper::toResponse);
    }

}
