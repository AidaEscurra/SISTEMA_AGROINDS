package modelo;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_persona")
public class PersonaModelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "per_id")
    private Long idPersona;

    @Column(name = "per_nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "per_apellido", nullable = false, length = 100)
    private String apellido;

    @Column(name = "per_documento", nullable = false, length = 20, unique = true)
    private String documento;

    @Column(name = "per_telefono", length = 20)
    private String telefono;

    @Column(name = "per_email", length = 100)
    private String email;

    @Column(name = "per_direccion", length = 150)
    private String direccion;

    @Column(name = "per_fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @Column(name = "per_estado", nullable = false)
    private boolean estado;

    // Constructor vacío requerido por Hibernate
    public PersonaModelo() {
    }

    // Getters y Setters
    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}