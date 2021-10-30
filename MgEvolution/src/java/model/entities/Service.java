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
public class Service implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date date;
    /*Declaracion de los atributos de Servicio, entre ellos se encuentra:
    stylist = ID del estilista,
    client = ID del cliente,
    El ID del producto es date = Fecha del servicio.
    Servicio es una tabla que nace de la relacion de Estilista y Cliente 
    por eso sus campos son los id de las dos tablas que une además de su propio id*/
    @ManyToOne
    private Stylist stylist;
    @ManyToOne
    private Client client;

    public Stylist getStylist(){
        return stylist;
    }
    
    public void setStylist(Stylist stylist){
        this.stylist = stylist;
    }
    
    public Client getClient(){
        return client;
    }
    
    public void setClient(Client client){
        this.client = client;
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
        if (!(object instanceof Service)) {
            return false;
        }
        Service other = (Service) object;
        if ((this.date == null && other.date != null) || (this.date != null && !this.date.equals(other.date))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.entities.service[ date=" + date + " ]";
    }
    
}