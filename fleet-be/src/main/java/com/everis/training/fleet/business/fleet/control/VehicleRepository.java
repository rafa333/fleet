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

    public List<Vehicle> getAllFreeVehicles(){
        Query q = em.createQuery("SELECT vehicle FROM Vehicle vehicle WHERE vehicle.vin NOT IN (SELECT customer.vehicle FROM Customer customer WHERE customer.vehicle NOT IN ('null'))");
        return (List<Vehicle>) q.getResultList();
    }

    public Vehicle findVehicle(String vin){
        return em.find(Vehicle.class, vin);
    }
}
