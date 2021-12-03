/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author judith
 */
@Entity
public class DetailService implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_DetailService;
    /*Declaracion de los atributos de Compra, entre ellos se encuentra:
    product = ID del producto,
    service = ID del service,
    amount = fecha de la compra,
    price = total de la compra,
    El ID del producto es id_DetailService = id del detalle de la compra/servicio.
    Detail Service es una tabla que nace de la relacion de Producto y Servicio 
    por eso entre sus campos se encuentra los ids de las dos tablas que une además de su propio id_DetailService*/
    @Column(length = 25)
    private Integer amount;
    
    @ManyToOne
    private Product product;
    @ManyToOne
    private Service service;

    public Long getId_DetailService() {
        return id_DetailService;
    }

    public void setId_DetailService(Long id_DetailService) {
        this.id_DetailService = id_DetailService;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Service getService(){
        return service;
    }
    
    public void setService(Service service){
        this.service = service;
    }
    
    public Product getProduct(){
        return product;
    }
    
    public void setProduct(Product product){
        this.product = product;
    }
    
   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_DetailService != null ? id_DetailService.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id_DetailService fields are not set
        if (!(object instanceof DetailService)) {
            return false;
        }
        DetailService other = (DetailService) object;
        if ((this.id_DetailService == null && other.id_DetailService != null) || (this.id_DetailService != null && !this.id_DetailService.equals(other.id_DetailService))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.entities.But[ date=" + id_DetailService + " ]";
    }
    
}