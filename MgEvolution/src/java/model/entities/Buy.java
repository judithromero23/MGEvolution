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
public class Buy implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long numTicket;
    /*Declaracion de los atributos de Compra, entre ellos se encuentra:
    product = ID del producto,
    client = ID del cliente,
    date = fecha de la compra,
    totalBuy = total de la compra,
    El ID del producto es numTicket = numero del ticket.
    Compra es una tabla que nace de la relacion de Producto y Cliente 
    por eso sus campos son los id de las dos tablas que une además de su propio id*/
    @Column(length = 50)
    private Date date;
    @Column(length = 50)
    private Float totalBuy;
    
    @ManyToOne
    private Product product;
    @ManyToOne
    private Client client;

    public Long getNumTicket() {
        return numTicket;
    }

    public void setNumTicket(Long numTicket) {
        this.numTicket = numTicket;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Float getTotalBuy() {
        return totalBuy;
    }

    public void setTotalBuy(Float totalBuy) {
        this.totalBuy = totalBuy;
    }
    
    public Client getClient(){
        return client;
    }
    
    public void setClient(Client client){
        this.client = client;
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
        hash += (numTicket != null ? numTicket.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Buy)) {
            return false;
        }
        Buy other = (Buy) object;
        if ((this.numTicket == null && other.numTicket != null) || (this.numTicket != null && !this.numTicket.equals(other.numTicket))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.entities.But[ date=" + numTicket + " ]";
    }
    
}