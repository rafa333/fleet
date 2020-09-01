package com.everis.training.fleet.business.fleet.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table (name = "fleet")
public class Fleet implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private int idfleet;
    @Column
    private String name;

    public int getIdfleet() {
        return idfleet;
    }

    public void setIdfleet(int idfleet) {
        this.idfleet = idfleet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
