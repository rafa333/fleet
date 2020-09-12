package com.everis.training.fleet.business.fleet.control;

import com.everis.training.fleet.business.exception.InvalidVinException;
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

    public void delete(final String vin) throws InvalidVinException{
        try {
            checkVin(vin);
            repo.deleteVehicle(vin);
        } catch (InvalidVinException e) {
            throw e;
        }
    }

    public void reserveCar(final Integer id, final String vin) throws InvalidVinException{
        try {
            checkVin(vin);
            repo.reserveCar(id, vin);
        } catch (InvalidVinException e) {
            throw e;
        }
    }

    public void add(final Vehicle vehicle) throws InvalidVinException {
        try {
            checkVin(vehicle.getVin());
            repo.addVehicle(vehicle);
        } catch (InvalidVinException e) {
            throw e;
        }
    }

    public Vehicle findVehicle(final String vin){
        return repo.findVehicle(vin);
    }

    public void checkVin(final String vin) throws InvalidVinException{
        int vinLength = 17;
        if (vin==null){
            throw new InvalidVinException("The vin can not be null");
        }else{
            if (vin.length()!=vinLength){
                throw new InvalidVinException("The VIN must have 17 characters");
            }
        }
    }
}
