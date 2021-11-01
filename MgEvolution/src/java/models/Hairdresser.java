/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.Persistence;
import model.controllers.StylistJpaController;
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
                if (e.getName().contains(filtro)) {
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
}
