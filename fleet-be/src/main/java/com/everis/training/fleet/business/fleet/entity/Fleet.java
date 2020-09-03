package com.everis.training.fleet.business.fleet.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "fleet")
@NamedQuery(name = "getAllFleets", query = "SELECT fleet FROM Fleet fleet")
public class Fleet implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private int idFleet;
    @Column
    private String name;

    public int getIdFleet() {
        return idFleet;
    }

    public void setIdFleet(int idFleet) {
        this.idFleet = idFleet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
