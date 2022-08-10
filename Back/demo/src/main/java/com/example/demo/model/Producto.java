package com.example.demo.model;
import javax.validation.constraints.Min;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private Usuario vendedor;
    @Column(name = "nombre", columnDefinition = "VARCHAR(255)")
    private String nombre;
    @Column(name = "descripcion", columnDefinition = "VARCHAR(255)")
    private String descripcion;
    @Column(name = "precio", columnDefinition = "DECIMAL")
    @Min(value = 0, message = "El precio mínimo es 0")
    private Float precio;
    @Column(name="tipo_de_moneda")
    @Enumerated(value = EnumType.STRING)
    private Moneda tipoDeMoneda;
    @Column(name="categoria")
    @Enumerated(value = EnumType.STRING)
    private Categoria categoria;
    @Column(name="activo",columnDefinition = "BOOLEAN")
    //@NotBlank
    private boolean activo;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Usuario getVendedor() {
        return vendedor;
    }

    public void setVendedor(Usuario vendedor) {
        this.vendedor = vendedor;
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

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Moneda getTipoDeMoneda() {
        return tipoDeMoneda;
    }

    public void setTipoDeMoneda(Moneda tipoDeMoneda) {
        this.tipoDeMoneda = tipoDeMoneda;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }


}
