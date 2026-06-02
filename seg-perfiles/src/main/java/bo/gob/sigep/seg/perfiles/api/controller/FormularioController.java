package bo.gob.sigep.seg.perfiles.api.controller;

import bo.gob.sigep.seg.perfiles.application.common.FormularioIdRequest;
import bo.gob.sigep.seg.perfiles.application.common.FormularioResponse;
import bo.gob.sigep.seg.perfiles.application.common.SaveFormularioCommand;
import bo.gob.sigep.seg.perfiles.application.service.*;
import bo.gob.sigep.seg.shared.dto.PageResponse;
import bo.gob.sigep.seg.shared.dto.PageSigep;
import bo.gob.sigep.seg.perfiles.application.service.*;
import jakarta.validation.Valid;
import org.mefp.core.logs.UtilString;
import org.mefp.core.logs.LogManager;
import org.mefp.core.util.MyUtilities;
import org.slf4j.Logger;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/formularios")
@Validated
public class FormularioController {

    private final IGuardarFormularioService guardarFormularioService;
    private final IModificarFormularioService modificarFormularioService;
    private final IPublicacionProcesoService publicacionProcesoService;
    private final IObtenerFormularioService obtenerProcesoService;
    private final IEliminarFormularioService eliminarFormularioService;

    private static final Logger logSigep = LogManager.getLogger("seguridad", "test");

    public FormularioController(
            IGuardarFormularioService guardarFormularioService, IModificarFormularioService modificarFormularioService,
            IPublicacionProcesoService publicacionProcesoService, IObtenerFormularioService obtenerProcesoService,
            IEliminarFormularioService eliminarFormularioService) {
        this.guardarFormularioService = guardarFormularioService;
        this.modificarFormularioService = modificarFormularioService;
        this.publicacionProcesoService = publicacionProcesoService;
        this.obtenerProcesoService = obtenerProcesoService;
        this.eliminarFormularioService = eliminarFormularioService;
    }

    @PostMapping("/crear")
    public ResponseEntity<FormularioResponse> crearFormulario(@Valid @RequestBody SaveFormularioCommand command) {
        System.out.println("mensajito");
        return ResponseEntity.status(HttpStatus.CREATED).body(guardarFormularioService.ejecutar(command));
    }

    @PutMapping("/{codigoFormularioRequest}")
    public ResponseEntity<FormularioResponse> modificarFormulario(
            @PathVariable Long codigoFormularioRequest, @Valid @RequestBody SaveFormularioCommand command) {
        FormularioResponse response = modificarFormularioService.ejecutar(codigoFormularioRequest, command);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/publicar/{codigoFormulario}")
    public ResponseEntity<Void> publicarFormulario(@PathVariable FormularioIdRequest request) {
        publicacionProcesoService.ejecutar(request);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{codigoFormulario}")
    public ResponseEntity<FormularioResponse> obtenerFormulario(@PathVariable Long codigoFormulario) {
        System.out.println("codigoFormulario: " + codigoFormulario);

        // usando la libreria logslibrary
        String test = "este es un mensajillo";
        System.out.println(UtilString.upper(test));

        logSigep.info("this's a SAMPLE............");

        // usando la libreria core-sigep
        System.out.println(MyUtilities.encriptar("myPassword"));

        FormularioResponse response = obtenerProcesoService.ejecutar(codigoFormulario);
        return ResponseEntity.ok(response);
    }

    @GetMapping()
    public ResponseEntity<List<FormularioResponse>> obtenerTodos() {
        List<FormularioResponse> response = obtenerProcesoService.ejecutar2();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/buscar")
    public ResponseEntity<PageResponse<FormularioResponse>> buscarConFiltros(
            @RequestParam(required = false) String paterno,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());
        return PageSigep.ok(obtenerProcesoService.ejecutar3(paterno, pageable));
    }

    @GetMapping("test")
    public String getASD() {
        return "Hello";
    }

    @DeleteMapping("/{codigoFormulario}")
    public ResponseEntity<Void> eliminarFormulario(@PathVariable Long codigoFormulario) {
        eliminarFormularioService.ejecutar(codigoFormulario);
        return ResponseEntity.noContent().build();
    }
}
