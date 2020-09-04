package com.everis.training.fleet.business.fleet.control;

import com.everis.training.fleet.business.fleet.entity.Fleet;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class FleetController {
    @Inject
    FleetRepository repo;

    public List<Fleet> getAllFleets(){
        return repo.getAll();
    }

    public Fleet findFleet(Integer id) {
        return repo.findFleet(id);
    }

    public void add(Fleet fleet) {
        repo.saveFleet(fleet);
    }

    public void delete(Integer id) {
        repo.deleteVehicle(id);
    }
}
