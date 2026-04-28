package modelo;

import java.util.Date;

public class FuncionarioModelo {
	private Long idFuncionario;
	private PersonaModelo persona; // Representa la FK persona_id
	private Date fechaIngreso;
	private String cargo;
	private String sector;
	private String funcion;
	private Integer estado;

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

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
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

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

}
