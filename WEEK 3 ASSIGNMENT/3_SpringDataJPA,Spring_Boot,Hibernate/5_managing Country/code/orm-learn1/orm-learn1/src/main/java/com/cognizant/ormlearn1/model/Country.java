package com.cognizant.ormlearn1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "country")  // match your existing table name
public class Country {

    @Id
    private String coCode;  // make sure this matches your table's primary key column

    private String coName;

    // Getters and Setters
    public String getCoCode() {
        return coCode;
    }

    public void setCoCode(String coCode) {
        this.coCode = coCode;
    }

    public String getCoName() {
        return coName;
    }

    public void setCoName(String coName) {
        this.coName = coName;
    }
}

