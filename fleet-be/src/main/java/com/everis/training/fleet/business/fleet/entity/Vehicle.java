package com.everis.training.fleet.business.fleet.entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name="vehicles")
@NamedQueries({
        @NamedQuery(name = "getAllVehicles", query = "SELECT Vehicle FROM Vehicle vehicle"),
        @NamedQuery(name = "getAllFreeVehicles", query = "SELECT vehicle FROM Vehicle vehicle WHERE NOT EXISTS (SELECT vehicle FROM Customer customer WHERE customer.vehicle = vehicle.vin)")
})
public class Vehicle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "fleet")
    private int fleet;
    @Column(name = "brand")
    private String brand;
    @Column(name = "model")
    private String model;
    @Column(name = "plate")
    private String plate;
    @Id
    private String vin;

    public int getFleet() {
        return fleet;
    }

    public void setFleet(int fleet) {
        this.fleet = fleet;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

}
