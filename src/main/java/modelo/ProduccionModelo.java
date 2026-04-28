package modelo;

import java.util.Date;
import java.util.List;

public class ProduccionModelo {
	private Long idProduccion;
	private Date fechaProduccion;
	private Double cantidadProducida;

	// Relaciones según el DER
	private ProductoModelo producto; // FK producto_id
	private FuncionarioModelo funcionario; // FK funcionario_id

	// Lista de insumos usados en esta producción específica
	private List<DetalleProduccionModelo> detalles;

	// Getters y Setters
	public Long getIdProduccion() {
		return idProduccion;
	}

	public void setIdProduccion(Long idProduccion) {
		this.idProduccion = idProduccion;
	}

	public Date getFechaProduccion() {
		return fechaProduccion;
	}

	public void setFechaProduccion(Date fechaProduccion) {
		this.fechaProduccion = fechaProduccion;
	}

	public Double getCantidadProducida() {
		return cantidadProducida;
	}

	public void setCantidadProducida(Double cantidadProducida) {
		this.cantidadProducida = cantidadProducida;
	}

	public ProductoModelo getProducto() {
		return producto;
	}

	public void setProducto(ProductoModelo producto) {
		this.producto = producto;
	}

	public FuncionarioModelo getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(FuncionarioModelo funcionario) {
		this.funcionario = funcionario;
	}

	public List<DetalleProduccionModelo> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleProduccionModelo> detalles) {
		this.detalles = detalles;
	}

}
