package modelo;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_funcionario")
public class FuncionarioModelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fun_id")
    private Long idFuncionario;

    // Relación OneToOne explicada en el video
    @OneToOne
    @JoinColumn(name = "per_id", nullable = false, unique = true)
    private PersonaModelo persona; 

    @Column(name = "fun_fecha_ingreso", nullable = false)
    private LocalDate fechaIngreso;

    @Column(name = "fun_cargo", nullable = false, length = 100)
    private String cargo;

    @Column(name = "fun_sector", nullable = false, length = 100)
    private String sector;

    @Column(name = "fun_funcion", nullable = false, length = 100)
    private String funcion;

    @Column(name = "fun_estado", nullable = false)
    private boolean estado;

    public FuncionarioModelo() {
        super();
    }

    // Getters y Setters
    public Long getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Long idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public PersonaModelo getPersona() {
        return persona;
    }

    public void setPersona(PersonaModelo persona) {
        this.persona = persona;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
