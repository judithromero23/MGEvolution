/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author judith
 */
@Entity
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codBarras;

    /*Declaracion de los atributos de Producto, entre ellos se encuentra:
    Name = Nombre del producto,
    Brand = Marca del producto (ID del proveedor),
    Category = Categoria a la que el producto pertenece,
    costClient = Precio del producto para el cliente,
    costSupplier = Precio del producto del proveedor,
    Stock = cantidad en stock del producto,
    El ID del producto es codBarras = Código de barras del producto.
    Producto tiene dos relaciones. Una es N:M con cliente de donde sale la
    tabla compra y otra relacion es N:1 con proveedor*/
    @Column(length = 80)
    private String name;
    @Column(length = 50)
    private String category;
    @Column(length = 50)
    private float costClient;
    @Column(length = 50)
    private Integer stock;
    @Column(length = 50)
    private Float costSupplier;

    @ManyToOne()
    @JoinColumn(name = "brand", nullable = false, updatable = false)
    private Supplier brand;

    public Supplier getBrand() {
        return brand;
    }

    public void setBrand(Supplier brand) {
        this.brand = brand;
    }
     public Float getCostSupplier() {
        return costSupplier;
    }

    public void setCostSupplier(Float costSupplier) {
        this.costSupplier = costSupplier;
    }

    public Long getCodBarras() {
        return codBarras;
    }

    public void setCodBarras(Long codBarras) {
        this.codBarras = codBarras;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getPrice() {
        return costClient;
    }

    public void setPrice(float price) {
        this.costClient = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Long getId() {
        return codBarras;
    }

    public void setId(Long id) {
        this.codBarras = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codBarras != null ? codBarras.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.codBarras == null && other.codBarras != null) || (this.codBarras != null && !this.codBarras.equals(other.codBarras))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.entities.Producto[ id=" + codBarras + " ]";
    }

}
