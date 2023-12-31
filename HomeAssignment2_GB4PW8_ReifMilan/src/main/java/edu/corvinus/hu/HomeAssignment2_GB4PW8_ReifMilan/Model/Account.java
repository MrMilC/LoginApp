package edu.corvinus.hu.HomeAssignment2_GB4PW8_ReifMilan.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String email;
    private String name;

    public Account() {}

    public Account(String email, String name) {
        this.email=email;
        this.name=name;
    }

    public Account(long id, String email, String name) {
        this.id = id;
        this.email = email;
        this.name=name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
