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
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.controllers.DetailServiceJpaController;
import model.controllers.ClientJpaController;
import model.controllers.ProductJpaController;
import model.controllers.ServiceJpaController;
import model.controllers.StylistJpaController;
import model.controllers.SupplierJpaController;
import model.entities.DetailService;
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

    /*public List<Supplier> filterSupplier(String filtro) {
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
    }*/

    public void deleteSupplier(Long id_brand) throws Exception {
        SupplierJpaController ejc = new SupplierJpaController(Persistence.createEntityManagerFactory(PERSISTENCIA));
        ejc.destroy(id_brand);
    }

    public void addSupplier(Supplier supplier) throws Exception {
        SupplierJpaController ejc = new SupplierJpaController(Persistence.createEntityManagerFactory(PERSISTENCIA));
        ejc.create(supplier);
    }

    public static Supplier searchSupplier(Long id_brand) {
        SupplierJpaController ejc = new SupplierJpaController(Persistence.createEntityManagerFactory(PERSISTENCIA));
        return ejc.findSupplier(id_brand);
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

    public void deleteClient(String DNI) throws Exception {
        ClientJpaController ejc = new ClientJpaController(Persistence.createEntityManagerFactory(PERSISTENCIA));
        ejc.destroy(DNI);
    }

    public void addClient(Client client) throws Exception {
        ClientJpaController ejc = new ClientJpaController(Persistence.createEntityManagerFactory(PERSISTENCIA));
        ejc.create(client);
    }

    public Client searchClient(String dni) {
        ClientJpaController ejc = new ClientJpaController(Persistence.createEntityManagerFactory(PERSISTENCIA));
        return ejc.findClient(dni);
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

//DetailService 
    public List<DetailService> getDetailService() {
        DetailServiceJpaController ejc = new DetailServiceJpaController(Persistence.createEntityManagerFactory(PERSISTENCIA));
        return ejc.findDetailServiceEntities();
    }

    public List<DetailService> filterDetailService (String filtro) {
        List<DetailService> buy = getDetailService();
        List<DetailService> filter = new ArrayList();
        if (!filtro.isEmpty()) {
            for (DetailService e : buy) {
                if (Objects.equals(e.getId_DetailService(), filtro)) {
                    filter.add(e);
                }
            }
        } else {
            filter = buy;
        }
        return filter;
    }

    public void deleteDetailService(Long id_DetailService) throws Exception {
        DetailServiceJpaController ejc = new DetailServiceJpaController(Persistence.createEntityManagerFactory(PERSISTENCIA));
        ejc.destroy(id_DetailService);
    }

    public void addDetailService(DetailService id_DetailService) throws Exception {
        DetailServiceJpaController ejc = new DetailServiceJpaController(Persistence.createEntityManagerFactory(PERSISTENCIA));
        ejc.create(id_DetailService);
    }

    public DetailService searchDetailService(Long id_DetailService) {
        DetailServiceJpaController ejc = new DetailServiceJpaController(Persistence.createEntityManagerFactory(PERSISTENCIA));
        return ejc.findDetailService(id_DetailService);
    }

    public void updateDetailService(DetailService detailService) throws Exception {
        DetailServiceJpaController ejc = new DetailServiceJpaController(Persistence.createEntityManagerFactory(PERSISTENCIA));
        ejc.edit(detailService);
    }
}
