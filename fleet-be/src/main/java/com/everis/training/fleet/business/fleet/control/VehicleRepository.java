package com.everis.training.fleet.business.fleet.control;


//Database connection and take the data


import com.everis.training.fleet.business.fleet.entity.Customer;
import com.everis.training.fleet.business.fleet.entity.Vehicle;
import com.google.gson.Gson;

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

    public String getAll(){
        Query q = em.createQuery("SELECT vehicle FROM Vehicle vehicle", Vehicle.class);
        Gson gson = new Gson();
        String jsonVehicleList = gson.toJson((List<Vehicle>) q.getResultList());
        return jsonVehicleList;
    }

    public String getAllFreeVehicles(){
        Query q = em.createQuery("SELECT vehicle FROM Vehicle vehicle WHERE vehicle.vin NOT IN (SELECT customer.vehicle FROM Customer customer WHERE customer.vehicle NOT IN ('null'))");
        Gson gson = new Gson();
        String jsonFreeVehicleList = gson.toJson((List<Vehicle>) q.getResultList());
        return jsonFreeVehicleList;
    }

    public String findVehicle(String vin){
        Gson gson = new Gson();
        String jsonVehicle = gson.toJson(em.find(Vehicle.class, vin));
        return jsonVehicle;
    }
}
