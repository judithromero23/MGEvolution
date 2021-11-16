/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author judith
 */
@Entity
public class Supplier implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String brand;
    /*Declaracion de los atributos de Proveedor, entre ellos se encuentra:
    phoneSupplier = Número del proveedor,
    nameSupplier = Nombre del proveedor,
    El ID del producto es brand = Código de barras del proveedor.
    Proveedor tiene una relacion 1:N con la entidad producto.*/
    @Column(length = 50)
    private Integer phoneSupplier;
    private String nameSupplier;
    
    

    
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getPhoneSupplier() {
        return phoneSupplier;
    }

    public void setPhoneSupplier(Integer phoneSupplier) {
        this.phoneSupplier = phoneSupplier;
    }

    public String getNameSupplier() {
        return nameSupplier;
    }

    public void setNameSupplier(String nameSupplier) {
        this.nameSupplier = nameSupplier;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (brand != null ? brand.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the brand fields are not set
        if (!(object instanceof Supplier)) {
            return false;
        }
        Supplier other = (Supplier) object;
        if ((this.brand == null && other.brand != null) || (this.brand != null && !this.brand.equals(other.brand))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.entities.Supplier[ id=" + brand + " ]";
    }
    
}
