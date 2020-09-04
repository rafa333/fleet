package com.everis.training.fleet.business.fleet.control;


//Check data -> Send to repository

import com.everis.training.fleet.business.fleet.entity.Vehicle;

import javax.faces.bean.*;
import javax.inject.Inject;
import java.io.FileNotFoundException;
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

    public void delete(String vin) {
        if (vinCheck(vin)){
            repo.deleteVehicle(vin);
        }
    }

    public void add(Vehicle vehicle){
        if (vinCheck(vehicle.getVin())){
            repo.addVehicle(vehicle);
        }
    }

    public Vehicle findVehicle(String vin){
        return repo.findVehicle(vin);
    }

    public Boolean vinCheck (String vin){
        int vinLength = 17;
        if (vin==null){
            throw new NullPointerException("The vin can not be null");
        }else{
            if (vin.length()==vinLength){
                return true;
            }else {
                //Custom exception vinLongitude
                return false;
            }
        }
    }
}
