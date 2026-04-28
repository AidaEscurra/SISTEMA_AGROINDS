package modelo;

public class MateriaPrimaModelo {
	private Long idMateriaPrima;
	private String nombre;
	private String descripcion;
	private Double stockActual;
	private String unidadMedida; // Ejemplo: Litros, KG, etc.

	// Getters y Setters
	public Long getIdMateriaPrima() {
		return idMateriaPrima;
	}

	public void setIdMateriaPrima(Long idMateriaPrima) {
		this.idMateriaPrima = idMateriaPrima;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getStockActual() {
		return stockActual;
	}

	public void setStockActual(Double stockActual) {
		this.stockActual = stockActual;
	}

	public String getUnidadMedida() {
		return unidadMedida;
	}

	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

}
