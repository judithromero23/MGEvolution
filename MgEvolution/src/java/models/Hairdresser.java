/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.persistence.Persistence;
import model.controllers.ProductJpaController;
import model.controllers.StylistJpaController;
import model.entities.Product;
import model.entities.Stylist;

/**
 *
 * @author judith
 */
public class Hairdresser {
    
     //Persistence
    public static final String PERSISTENCIA = "MgEvolutionPU";

    //Stylist
    public List<Stylist> getStylist() {
        StylistJpaController ejc = new StylistJpaController(Persistence.createEntityManagerFactory(PERSISTENCIA));
        return ejc.findStylistEntities();
    }

    public List<Stylist> getStylistAlfabeticamente() {
        List<Stylist> stylist = getStylist();
        Collections.sort(stylist, (e1, e2)
                -> (e1.getName()).compareTo(e2.getName()));
        return stylist;
    }

    public List<Stylist> filterStylist(String filtro) {
        List<Stylist> stylist = getStylist();
        List<Stylist> filter = new ArrayList();
        if (!filtro.isEmpty()) {
            for (Stylist e : stylist) {
                if (e.getLogin().contains(filtro)) {
                    filter.add(e);
                }
            }
        } else {
            filter = stylist;
        }
        return filter;
    }

    public void deleteStylist(Long id) throws Exception {
        StylistJpaController ejc = new StylistJpaController(Persistence.createEntityManagerFactory(PERSISTENCIA));
        ejc.destroy(id);
    }

    public void addStylist(Stylist stylist) throws Exception {
        StylistJpaController ejc = new StylistJpaController(Persistence.createEntityManagerFactory(PERSISTENCIA));
        ejc.create(stylist);
        System.out.println(stylist);
    }

    public Stylist searchStylist(Long id) {
        StylistJpaController ejc = new StylistJpaController(Persistence.createEntityManagerFactory(PERSISTENCIA));
        return ejc.findStylist(id);
    }

    public void updateStylist(Stylist stylist) throws Exception {
        StylistJpaController ejc = new StylistJpaController(Persistence.createEntityManagerFactory(PERSISTENCIA));
        ejc.edit(stylist);
    }
    
    
//Product
    public List<Product> getProduct() {
        ProductJpaController ejc = new ProductJpaController(Persistence.createEntityManagerFactory(PERSISTENCIA));
        return ejc.findProductEntities();
    }

    public List<Product> getProducttAlfabeticamente() {
        List<Product> product = getProduct();
        Collections.sort(product, (e1, e2)
                -> (e1.getName()).compareTo(e2.getName()));
        return product;
    }

    public List<Product> filterProduct(String filtro) {
        List<Product> product = getProduct();
        List<Product> filter = new ArrayList();
        if (!filtro.isEmpty()) {
            for (Product e : product) {
                if (Objects.equals(e.getCodBarras(), filtro)) {
                    filter.add(e);
                }
            }
        } else {
            filter = product;
        }
        return filter;
    }

    public void deleteProduct(Long id) throws Exception {
        ProductJpaController ejc = new ProductJpaController(Persistence.createEntityManagerFactory(PERSISTENCIA));
        ejc.destroy(id);
    }

    public void addProduct(Product product) throws Exception {
        ProductJpaController ejc = new ProductJpaController(Persistence.createEntityManagerFactory(PERSISTENCIA));
        ejc.create(product);
        System.out.println(product);
    }

    public Product searchProduct(Long codBarras) {
        ProductJpaController ejc = new ProductJpaController(Persistence.createEntityManagerFactory(PERSISTENCIA));
        return ejc.findProduct(codBarras);
    }

    public void updateProduct(Product product) throws Exception {
        ProductJpaController ejc = new ProductJpaController(Persistence.createEntityManagerFactory(PERSISTENCIA));
        ejc.edit(product);
    }
}

