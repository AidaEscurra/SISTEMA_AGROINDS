package modelo;

public class DetalleProduccionModelo {
	private Long idDetalle;
	private ProduccionModelo produccion; // Relación con la cabecera
	private MateriaPrimaModelo materiaPrima; // El insumo utilizado
	private Double cantidadUtilizada;

	// Getters y Setters
	public Long getIdDetalle() {
		return idDetalle;
	}

	public void setIdDetalle(Long idDetalle) {
		this.idDetalle = idDetalle;
	}

	public ProduccionModelo getProduccion() {
		return produccion;
	}

	public void setProduccion(ProduccionModelo produccion) {
		this.produccion = produccion;
	}

	public MateriaPrimaModelo getMateriaPrima() {
		return materiaPrima;
	}

	public void setMateriaPrima(MateriaPrimaModelo materiaPrima) {
		this.materiaPrima = materiaPrima;
	}

	public Double getCantidadUtilizada() {
		return cantidadUtilizada;
	}

	public void setCantidadUtilizada(Double cantidadUtilizada) {
		this.cantidadUtilizada = cantidadUtilizada;
	}

}
