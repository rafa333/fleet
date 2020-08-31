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

    public void add() {
        Vehicle vehicle = new Vehicle();
        vehicle.setFleet(1);
        vehicle.setBrand("BMW");
        vehicle.setModel("320d");
        vehicle.setPlate("1111JTÑ");
        vehicle.setVin("123456789qwertyu9");
        repo.saveVehicle(vehicle);
    }

    public void delete(String vin) {
        if (vin.length() == 17){
            repo.deleteVehicle(vin);
        }else{
            System.out.println("Revise que el VIN que ha introducido contenga 17 caracteres.");
        }

    }

    public void update(){
        Vehicle vehicle = new Vehicle();
        vehicle.setFleet(1);
        vehicle.setBrand("");
        vehicle.setModel("");
        vehicle.setPlate("");
        vehicle.setVin("");
        repo.updateVehicle(vehicle);
    }

    public Vehicle findVehicle(String vin){
        return repo.findVehicle(vin);
    }

}
