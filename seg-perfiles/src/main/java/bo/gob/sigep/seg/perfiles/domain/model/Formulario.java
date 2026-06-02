package bo.gob.sigep.seg.perfiles.domain.model;

import bo.gob.sigep.seg.perfiles.domain.enums.AccionFormulario;
import bo.gob.sigep.seg.perfiles.domain.enums.EstadoFormulario;
import bo.gob.sigep.seg.perfiles.domain.maquinaestados.FormularioValidacionEstado;

import java.time.LocalDate;

public class Formulario {
    private Long codigoFormulario;
    private String codigoTipoFormulario;
    private String paterno;
    private String materno;
    private String nombres;
    private String codigoProceso;
    private String responsableCreacion;
    private LocalDate fechaCreacion;
    private int gestion;
    private EstadoFormulario estado;

    // Constructor para crear nuevo formulario
    public static Formulario crear(String codigoTipoFormulario,
                                   String paterno,
                                   String materno,
                                   String nombres,
                                   String codigoProceso,
                                   String responsableCreacion
    ) {
        Formulario formulario = new Formulario(codigoTipoFormulario, paterno, materno, nombres, codigoProceso, responsableCreacion);
        validarDatosObligatorios(formulario);
        return formulario;
    }

    private Formulario(
            String codigoTipoFormulario,
            String paterno,
            String materno,
            String nombres,
            String codigoProceso,
            String responsableCreacion
            ) {
        this.codigoTipoFormulario = codigoTipoFormulario;
        this.paterno = paterno;
        this.materno = materno;
        this.nombres = nombres;
        this.codigoProceso = codigoProceso;
        this.responsableCreacion = responsableCreacion;
        this.fechaCreacion = LocalDate.now();
        this.gestion = LocalDate.now().getYear();
        this.estado = EstadoFormulario.INICIAL;
        this.estado = this.realizarAccion(this.estado, AccionFormulario.CREAR);
    }

    public static Formulario reconstruir(Long codigoFormulario,
                                         String codigoTipoFormulario,
                                         String paterno,
                                         String materno,
                                         String nombres,
                                         String codigoProceso,
                                         String responsableCreacion,
                                         LocalDate fechaCreacion,
                                         int gestion,
                                         EstadoFormulario estado) {
        return new Formulario(codigoFormulario, codigoTipoFormulario, paterno,
                materno, nombres, codigoProceso, responsableCreacion,
                fechaCreacion, gestion, estado);
    }

    private Formulario (
            Long codigoFormulario,
            String codigoTipoFormulario,
            String paterno,
            String materno,
            String nombres,
            String codigoProceso,
            String responsableCreacion,
            LocalDate fechaCreacion,
            int gestion,
            EstadoFormulario estadoFormulario
    ) {
        this.codigoFormulario = codigoFormulario;
        this.codigoTipoFormulario = codigoTipoFormulario;
        this.paterno = paterno;
        this.materno = materno;
        this.nombres = nombres;
        this.codigoProceso = codigoProceso;
        this.responsableCreacion = responsableCreacion;
        this.fechaCreacion = fechaCreacion;
        this.gestion = gestion;
        this.estado = estadoFormulario;
    }

    // Métodos de negocio
    public void modificar(
            String paterno,
            String materno,
            String nombres,
            AccionFormulario accion) {

        this.paterno = paterno;
        this.materno = materno;
        this.nombres = nombres;
        this.estado = this.realizarAccion(this.estado, accion);
    }

    private static void validarDatosObligatorios(Formulario formulario) {
        if (formulario.codigoTipoFormulario == null || formulario.codigoTipoFormulario.isBlank()) {
            throw new IllegalArgumentException("El tipo de formulario es obligatorio");
        }
    }

    private EstadoFormulario realizarAccion(EstadoFormulario estado, AccionFormulario accion) {
        System.out.println("Formulario con estado: " + estado.name() + " realizando acción: " + accion.name());
        return FormularioValidacionEstado.INSTANCE.next(estado, accion);
    }

    public void eliminar() {
        this.estado = this.realizarAccion(this.estado, AccionFormulario.ELIMINAR);
    }

    public Long getCodigoFormulario() {
        return codigoFormulario;
    }

    public String getCodigoTipoFormulario() {
        return codigoTipoFormulario;
    }

    public String getPaterno() {
        return paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public String getNombres() {
        return nombres;
    }

    public String getCodigoProceso() {
        return codigoProceso;
    }

    public String getResponsableCreacion() {
        return responsableCreacion;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public int getGestion() {
        return gestion;
    }

    public EstadoFormulario getEstado() {
        return estado;
    }

}
