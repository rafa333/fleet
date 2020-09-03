package com.everis.training.fleet.business.fleet.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "customer")
@NamedQuery(name = "getAllCustomers", query = "SELECT customer FROM Customer customer")
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private int idcustomer;
    @Column
    private String name;
    @Column
    private String vehicle;

    public int getIdcustomer() {
        return idcustomer;
    }

    public void setIdcustomer(int idcustomer) {
        this.idcustomer = idcustomer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }
}
