package com.everis.training.fleet.business.fleet.control;

import com.everis.training.fleet.business.fleet.entity.Fleet;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class FleetController {
    @Inject
    FleetRepository repo;

    public String getAllFleets(){
        return repo.getAll();
    }

    public String findFleet(Integer id) {
        return repo.findFleet(id);
    }

    public void add(Fleet fleet) {
        repo.saveFleet(fleet);
    }
}
