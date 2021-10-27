/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author judith
 */
@Entity
public class Buy implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date date;
    
    @ManyToOne
    private Product product;
    @ManyToOne
    private Client client;
    
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
    
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (date != null ? date.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Buy)) {
            return false;
        }
        Buy other = (Buy) object;
        if ((this.date == null && other.date != null) || (this.date != null && !this.date.equals(other.date))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.entities.But[ date=" + date + " ]";
    }
    
}