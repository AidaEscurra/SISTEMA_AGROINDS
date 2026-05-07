package modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_produccion")
public class ProduccionModelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prod_id")
    private Long idProduccion;

    @Column(name = "prod_fecha_produccion", nullable = false)
    private LocalDate fechaProduccion;

    @Column(name = "prod_cantidad_producida", nullable = false)
    private Double cantidadProducida;

    // Relación: Muchas producciones pueden ser realizadas por un funcionario
    @ManyToOne
    @JoinColumn(name = "fun_id", nullable = false)
    private FuncionarioModelo funcionario;

    // Relación: Muchas producciones pueden ser de un mismo tipo de producto
    @ManyToOne
    @JoinColumn(name = "prod_id_producto", nullable = false)
    private ProductoModelo producto;

    // Relación Bidireccional: Una producción tiene muchos detalles (insumos usados)
    // cascade = CascadeType.ALL permite guardar cabecera y detalles en un solo paso
    @OneToMany(mappedBy = "produccion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleProduccionModelo> detalles = new ArrayList<>();

    // Constructor vacío obligatorio
    public ProduccionModelo() {
        super();
    }

    // Métodos de conveniencia para manejar la lista de detalles
    public void agregarDetalle(DetalleProduccionModelo detalle) {
        this.detalles.add(detalle);
        detalle.setProduccion(this); // Mantiene la sincronía de la relación
    }

    public void quitarDetalle(DetalleProduccionModelo detalle) {
        this.detalles.remove(detalle);
        detalle.setProduccion(null);
    }

    // Getters y Setters
    public Long getIdProduccion() {
        return idProduccion;
    }

    public void setIdProduccion(Long idProduccion) {
        this.idProduccion = idProduccion;
    }

    public LocalDate getFechaProduccion() {
        return fechaProduccion;
    }

    public void setFechaProduccion(LocalDate fechaProduccion) {
        this.fechaProduccion = fechaProduccion;
    }

    public Double getCantidadProducida() {
        return cantidadProducida;
    }

    public void setCantidadProducida(Double cantidadProducida) {
        this.cantidadProducida = cantidadProducida;
    }

    public FuncionarioModelo getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(FuncionarioModelo funcionario) {
        this.funcionario = funcionario;
    }

    public ProductoModelo getProducto() {
        return producto;
    }

    public void setProducto(ProductoModelo producto) {
        this.producto = producto;
    }

    public List<DetalleProduccionModelo> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleProduccionModelo> detalles) {
        this.detalles = detalles;
    }
}