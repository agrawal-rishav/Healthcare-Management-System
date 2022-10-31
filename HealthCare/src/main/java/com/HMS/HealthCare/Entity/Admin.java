package com.HMS.HealthCare.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Admin {
    
    @Id
    private Long ID;

    private String username;
    private String password;
    private String updationdate;

    public Admin() {}

    public Long getID() {
        return ID;
    }

    public void setID(Long iD) {
        ID = iD;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUpdationdate() {
        return updationdate;
    }

    public void setUpdationdate(String updationDate) {
        this.updationdate = updationDate;
    }

    
}
