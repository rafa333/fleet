package com.everis.training.fleet.business.fleet.control;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class FleetController {
    @Inject
    FleetRepository repo;

    public String getAllFleets(){
        return repo.getAll();
    }
}
