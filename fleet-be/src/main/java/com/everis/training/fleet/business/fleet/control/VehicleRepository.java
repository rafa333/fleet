package com.everis.training.fleet.business.fleet.control;


//Database connection and take the data


import com.everis.training.fleet.business.fleet.entity.Vehicle;

import javax.faces.bean.ApplicationScoped;
import javax.persistence.*;
import java.util.List;

@ApplicationScoped


public class VehicleRepository {
    @PersistenceContext(unitName = "fleet")
    EntityManager em;

    public void deleteVehicle(String vin){
        Vehicle vehicle;
        vehicle = em.find(Vehicle.class, vin);
        em.remove(vehicle);
    }

    public void addVehicle(Vehicle vehicle){
        em.merge(vehicle);
    }

    public List<Vehicle> getAll(){
        Query q = em.createNamedQuery("getAllVehicles", Vehicle.class);
        return q.getResultList();
    }

    public List<Vehicle> getAllFreeVehicles(){
        Query q = em.createNamedQuery("getAllFreeVehicles");
        return q.getResultList();
    }

    public Vehicle findVehicle(String vin){
        return em.find(Vehicle.class, vin);
    }
}
