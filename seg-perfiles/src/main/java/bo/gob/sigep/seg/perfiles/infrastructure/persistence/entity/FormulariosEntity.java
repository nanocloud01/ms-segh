package bo.gob.sigep.seg.perfiles.infrastructure.persistence.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "formularios", schema = "compac")
public class FormulariosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "form_gen")
    @SequenceGenerator(name = "form_gen", sequenceName = "compac.seq_formularios", allocationSize = 1)
    @Column(name = "CODIGOFORMULARIO", nullable = false)
    private Long codigoFormulario;

    @Column(name = "CODIGOTIPOFORMULARIO", nullable = false)
    private String codigoTipoFormulario;

    @Column(nullable = false)
    private String paterno;

    @Column(nullable = false)
    private String materno;

    @Column(nullable = false)
    private String nombres;

    @Column(name = "CODIGOPROCESO", nullable = false)
    private String codigoProceso;

    @Column(name = "RESPONSABLECREACION", nullable = false)
    private String responsableCreacion;

    @Column(name = "FECHACREACION", nullable = false)
    private LocalDate fechaCreacion;

    @Column(nullable = false)
    private int gestion;

    @Column(nullable = false)
    private String estado;

    public Long getCodigoFormulario() {
        return codigoFormulario;
    }

    public void setCodigoFormulario(Long codigoFormulario) {
        this.codigoFormulario = codigoFormulario;
    }

    public String getCodigoTipoFormulario() {
        return codigoTipoFormulario;
    }

    public void setCodigoTipoFormulario(String codigoTipoFormulario) {
        this.codigoTipoFormulario = codigoTipoFormulario;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getCodigoProceso() {
        return codigoProceso;
    }

    public void setCodigoProceso(String codigoProceso) {
        this.codigoProceso = codigoProceso;
    }

    public String getResponsableCreacion() {
        return responsableCreacion;
    }

    public void setResponsableCreacion(String responsableCreacion) {
        this.responsableCreacion = responsableCreacion;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getGestion() {
        return gestion;
    }

    public void setGestion(int gestion) {
        this.gestion = gestion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
