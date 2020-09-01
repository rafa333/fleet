package com.everis.training.fleet.business.fleet.control;


//Check data -> Send to repository

import com.everis.training.fleet.business.fleet.entity.Vehicle;

import javax.faces.bean.*;
import javax.inject.Inject;

@ApplicationScoped
public class VehicleController {

    @Inject
    VehicleRepository repo;

    public String getAllVehicles() {
        return repo.getAll();
    }

    public void add(Vehicle vehicle) {
        if (vehicle.getVin().length()==17){
            repo.saveVehicle(vehicle);
        }
    }

    public void delete(String vin) {
        if (vin.length() == 17){
            repo.deleteVehicle(vin);
        }

    }

    public void update(Vehicle vehicle){
        if (vehicle.getVin().length()==17){
            repo.updateVehicle(vehicle);
        }
    }

    public String findVehicle(String vin){
        return repo.findVehicle(vin);
    }

}
