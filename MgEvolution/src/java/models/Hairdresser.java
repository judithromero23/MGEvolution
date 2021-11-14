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
import model.controllers.BuyJpaController;
import model.controllers.ClientJpaController;
import model.controllers.ProductJpaController;
import model.controllers.ServiceJpaController;
import model.controllers.StylistJpaController;
import model.controllers.SupplierJpaController;
import model.entities.Buy;
import model.entities.Client;
import model.entities.Product;
import model.entities.Service;
import model.entities.Stylist;
import model.entities.Supplier;

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
    }

    public Stylist searchStylist(Long id) {
        StylistJpaController ejc = new StylistJpaController(Persistence.createEntityManagerFactory(PERSISTENCIA));
        return ejc.findStylist(id);
    }

    public void updateStylist(Stylist stylist) throws Exception {
        StylistJpaController ejc = new StylistJpaController(Persistence.createEntityManagerFactory(PERSISTENCIA));
        ejc.edit(stylist);
    }
//Supplier
    public List<Supplier> getSupplier() {
        SupplierJpaController ejc = new SupplierJpaController(Persistence.createEntityManagerFactory(PERSISTENCIA));
        return ejc.findSupplierEntities();
    }

    public List<Supplier> getSupplierAlfabeticamente() {
        List<Supplier> supplier = getSupplier();
        Collections.sort(supplier, (e1, e2)
                -> (e1.getBrand()).compareTo(e2.getBrand()));
        return supplier;
    }

    public List<Supplier> filterSupplier(String filtro) {
        List<Supplier> supplier = getSupplier();
        List<Supplier> filter = new ArrayList();
        if (!filtro.isEmpty()) {
            for (Supplier e : supplier) {
                if (e.getBrand().contains(filtro)) {
                    filter.add(e);
                }
            }
        } else {
            filter = supplier;
        }
        return filter;
    }

    public void deleteSupplier(String brand) throws Exception {
        SupplierJpaController ejc = new SupplierJpaController(Persistence.createEntityManagerFactory(PERSISTENCIA));
        ejc.destroy(brand);
    }

    public void addSupplier(Supplier supplier) throws Exception {
        SupplierJpaController ejc = new SupplierJpaController(Persistence.createEntityManagerFactory(PERSISTENCIA));
        ejc.create(supplier);
    }

    public Supplier searchSupplier(String brand) {
        SupplierJpaController ejc = new SupplierJpaController(Persistence.createEntityManagerFactory(PERSISTENCIA));
        return ejc.findSupplier(brand);
    }

    public void updateSupplier(Supplier supplier) throws Exception {
        SupplierJpaController ejc = new SupplierJpaController(Persistence.createEntityManagerFactory(PERSISTENCIA));
        ejc.edit(supplier);
    }
    
    
//Product 
    public List<Product> getProduct() {
        ProductJpaController ejc = new ProductJpaController(Persistence.createEntityManagerFactory(PERSISTENCIA));
        return ejc.findProductEntities();
    }

    public List<Product> getProductAlfabeticamente() {
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

    public void deleteProduct(Long codBarras) throws Exception {
        ProductJpaController ejc = new ProductJpaController(Persistence.createEntityManagerFactory(PERSISTENCIA));
        ejc.destroy(codBarras);
    }

    public void addProduct(Product product) throws Exception {
        ProductJpaController ejc = new ProductJpaController(Persistence.createEntityManagerFactory(PERSISTENCIA));
        ejc.create(product);
    }

    public Product searchProduct(Long codBarras) {
        ProductJpaController ejc = new ProductJpaController(Persistence.createEntityManagerFactory(PERSISTENCIA));
        return ejc.findProduct(codBarras);
    }

    public void updateProduct(Product product) throws Exception {
        ProductJpaController ejc = new ProductJpaController(Persistence.createEntityManagerFactory(PERSISTENCIA));
        ejc.edit(product);
    }

   
//Client 
    public List<Client> getClient() {
        ClientJpaController ejc = new ClientJpaController(Persistence.createEntityManagerFactory(PERSISTENCIA));
        return ejc.findClientEntities();
    }

    public List<Client> getClientAlfabeticamente() {
        List<Client> client = getClient();
        Collections.sort(client, (e1, e2)
                -> (e1.getName()).compareTo(e2.getName()));
        return client;
    }

    public List<Client> filterClient(String filtro) {
        List<Client> client = getClient();
        List<Client> filter = new ArrayList();
        if (!filtro.isEmpty()) {
            for (Client e : client) {
                if (Objects.equals(e.getDNI(), filtro)) {
                    filter.add(e);
                }
            }
        } else {
            filter = client;
        }
        return filter;
    }

    public void deleteClient(Long DNI) throws Exception {
        ClientJpaController ejc = new ClientJpaController(Persistence.createEntityManagerFactory(PERSISTENCIA));
        ejc.destroy(DNI);
    }

    public void addClient(Client client) throws Exception {
        ClientJpaController ejc = new ClientJpaController(Persistence.createEntityManagerFactory(PERSISTENCIA));
        ejc.create(client);
    }

    public Client searchClient(Long DNI) {
        ClientJpaController ejc = new ClientJpaController(Persistence.createEntityManagerFactory(PERSISTENCIA));
        return ejc.findClient(DNI);
    }

    public void updateClient(Client client) throws Exception {
        ClientJpaController ejc = new ClientJpaController(Persistence.createEntityManagerFactory(PERSISTENCIA));
        ejc.edit(client);
    }
    
//Service 
    public List<Service> getService() {
        ServiceJpaController ejc = new ServiceJpaController(Persistence.createEntityManagerFactory(PERSISTENCIA));
        return ejc.findServiceEntities();
    }

    public List<Service> filterService(String filtro) {
        List<Service> service = getService();
        List<Service> filter = new ArrayList();
        if (!filtro.isEmpty()) {
            for (Service e : service) {
                if (Objects.equals(e.getId(), filtro)) {
                    filter.add(e);
                }
            }
        } else {
            filter = service;
        }
        return filter;
    }

    public void deleteService(Long id) throws Exception {
        ServiceJpaController ejc = new ServiceJpaController(Persistence.createEntityManagerFactory(PERSISTENCIA));
        ejc.destroy(id);
    }

    public void addService(Service service) throws Exception {
        ServiceJpaController ejc = new ServiceJpaController(Persistence.createEntityManagerFactory(PERSISTENCIA));
        ejc.create(service);
    }

    public Service searchService(Long id) {
        ServiceJpaController ejc = new ServiceJpaController(Persistence.createEntityManagerFactory(PERSISTENCIA));
        return ejc.findService(id);
    }

    public void updateService(Service service) throws Exception {
        ServiceJpaController ejc = new ServiceJpaController(Persistence.createEntityManagerFactory(PERSISTENCIA));
        ejc.edit(service);
    }
    
//Buy 
    public List<Buy> getBuy() {
        BuyJpaController ejc = new BuyJpaController(Persistence.createEntityManagerFactory(PERSISTENCIA));
        return ejc.findBuyEntities();
    }

    public List<Buy> filterBuy(String filtro) {
        List<Buy> buy = getBuy();
        List<Buy> filter = new ArrayList();
        if (!filtro.isEmpty()) {
            for (Buy e : buy) {
                if (Objects.equals(e.getNumTicket(), filtro)) {
                    filter.add(e);
                }
            }
        } else {
            filter = buy;
        }
        return filter;
    }

    public void deleteBuy(Long numTicket) throws Exception {
        BuyJpaController ejc = new BuyJpaController(Persistence.createEntityManagerFactory(PERSISTENCIA));
        ejc.destroy(numTicket);
    }

    public void addBuy(Buy buy) throws Exception {
        BuyJpaController ejc = new BuyJpaController(Persistence.createEntityManagerFactory(PERSISTENCIA));
        ejc.create(buy);
    }

    public Buy searchBuy(Long numTicket) {
        BuyJpaController ejc = new BuyJpaController(Persistence.createEntityManagerFactory(PERSISTENCIA));
        return ejc.findBuy(numTicket);
    }

    public void updateBuy(Buy buy) throws Exception {
        BuyJpaController ejc = new BuyJpaController(Persistence.createEntityManagerFactory(PERSISTENCIA));
        ejc.edit(buy);
    }
}
