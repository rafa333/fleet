package com.everis.training.fleet.business.fleet.control;


//Database connection and take the data


import com.everis.training.fleet.business.fleet.entity.Vehicle;

import javax.ejb.*;
import javax.persistence.*;
import java.util.List;

@LocalBean
@Stateless
public class VehicleRepository {
    @PersistenceContext
    EntityManager em;
    public void saveVehicle(Vehicle vehicle){
        em.persist(vehicle);
        em.flush();
    }

    public void deleteVehicle(String vin){
        Vehicle vehicle;
        vehicle = em.find(Vehicle.class, vin);
        em.remove(vehicle);
    }

    public void updateVehicle(Vehicle vehicle){
        em.merge(vehicle);
    }

    public List<Vehicle> getAll(){
        Query q = em.createQuery("SELECT vehicle FROM Vehicle vehicle", Vehicle.class);
        return (List<Vehicle>) q.getResultList();
    }

    public Vehicle findVehicle(String vin){
        return em.find(Vehicle.class, vin);
    }
}
