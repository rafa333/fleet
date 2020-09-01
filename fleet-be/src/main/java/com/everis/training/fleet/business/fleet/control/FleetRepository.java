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
    public String getAll(){
        Query q = em.createQuery("SELECT fleet FROM Fleet fleet", Fleet.class);
        Gson gson = new Gson();
        String jsonFleetList = gson.toJson((List <Fleet>) q.getResultList());
        return jsonFleetList;
    }

    public String findFleet(Integer id) {
        Gson gson = new Gson();
        String jsonFleet = gson.toJson(em.find(Fleet.class, id));
        return jsonFleet;
    }
}
