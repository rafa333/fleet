package com.everis.training.fleet.business.fleet.control;

import com.everis.training.fleet.business.exception.VinLengthException;
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

    public void delete(String vin) throws Exception{
        try {
            vinCheck(vin);
            repo.deleteVehicle(vin);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void reserveCar(Integer id, String vin) throws Exception{
        try {
            vinCheck(vin);
            repo.reserveCar(id, vin);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void add(Vehicle vehicle) throws Exception {
        try {
            vinCheck(vehicle.getVin());
            repo.addVehicle(vehicle);
        } catch (Exception e) {
            throw e;
        }
    }

    public Vehicle findVehicle(String vin){
        return repo.findVehicle(vin);
    }

    public void vinCheck (String vin) throws Exception{
        int vinLength = 17;
        if (vin==null){
            throw new NullPointerException("The vin can not be null");
        }else{
            if (vin.length()!=vinLength){
                throw new VinLengthException("The VIN must have 17 characters");
            }
        }
    }
}
