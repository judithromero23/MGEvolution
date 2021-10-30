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

/**
 *
 * @author judith
 */
@Entity
public class Stylist implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /*Declaracion de los atributos de Estilista, entre ellos se encuentra:
    name = Nombre del estilista,
    lastName = Apellido del estilista,
    area = Especialidad del estilista,
    salary = Sueldo del estilista,
    Como cualquier estilista puede ser administrador tambien vamos a guardar un login
    y un password.
    login = Nombre usuario Estilista.
    password = Contraseña del estilista
    Estilista tiene una relación N:M con la entidad Cliente de donde
    nace la tabla "Servicios"*/
    @Column(length = 80)
    private String name;
    @Column(length = 80)
    private String lastName;
    @Column(length = 50)
    private String area;
    @Column(length = 50)
    private float salary;
    @Column(length = 35)
    private Boolean admin;
    @Column(length = 35, unique = true)
    private String login;
    @Column(length = 35)
    private String password;
    @Column(length = 50)
    private String email;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCorreo() {
        return email;
    }

    public void setCorreo(String correo) {
        this.email = correo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean administrador) {
        this.admin = administrador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stylist)) {
            return false;
        }
        Stylist other = (Stylist) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.entities.stylist[ id=" + id + " ]";
    }

}
