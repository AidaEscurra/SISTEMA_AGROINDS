package modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_materia_prima")
public class MateriaPrimaModelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mat_id")
    private Long idMateriaPrima;

    @Column(name = "mat_nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "mat_descripcion", length = 255)
    private String descripcion;

    @Column(name = "mat_stock_actual", nullable = false)
    private Double stockActual;

    @Column(name = "mat_unidad_medida", nullable = false, length = 20)
    private String unidadMedida; // Ejemplo: Litros, KG, etc.

    // Constructor vacío obligatorio para Hibernate
    public MateriaPrimaModelo() {
        super();
    }

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