package modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_detalle_produccion")
public class DetalleProduccionModelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "det_id")
    private Long idDetalle;

    // Muchos detalles pertenecen a una sola producción
    @ManyToOne
    @JoinColumn(name = "prod_id", nullable = false)
    private ProduccionModelo produccion;

    // Muchos detalles pueden usar la misma materia prima
    @ManyToOne
    @JoinColumn(name = "mat_id", nullable = false)
    private MateriaPrimaModelo materiaPrima;

    @Column(name = "det_cantidad_utilizada", nullable = false)
    private Double cantidadUtilizada;

    public DetalleProduccionModelo() {
        super();
    }

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