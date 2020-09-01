package com.everis.training.fleet.business.fleet.control;

import com.everis.training.fleet.business.fleet.entity.Fleet;
import com.google.gson.Gson;

import javax.faces.bean.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@ApplicationScoped
public class FleetRepository {
    @PersistenceContext(unitName = "fleet")
    EntityManager em;
    public List<Fleet> getAll(){
        Query q = em.createQuery("SELECT fleet FROM Fleet fleet", Fleet.class);
        return (List <Fleet>) q.getResultList();
    }

    public Fleet findFleet(Integer id) {
        return em.find(Fleet.class, id);
    }

    public void saveFleet(Fleet fleet) {
        em.persist(fleet);
        em.flush();
    }

    public void updateFleet(Fleet fleet) {
        em.merge(fleet);
    }

    public void deleteVehicle(Integer id) {
        Fleet fleet;
        fleet = em.find(Fleet.class, id);
        em.remove(fleet);
    }
}
