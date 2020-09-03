package com.everis.training.fleet.business.fleet.control;


//Check data -> Send to repository

import com.everis.training.fleet.business.fleet.entity.Vehicle;

import javax.faces.bean.*;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class VehicleController {

    @Inject
    VehicleRepository repo;

    public List<Vehicle> getAllVehicles() {
        return repo.getAll();
    }
    public List<Vehicle> getAllFreeVehicles() {
        return repo.getAllFreeVehicles();
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

    public Vehicle findVehicle(String vin){
        return repo.findVehicle(vin);
    }

}
