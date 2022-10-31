package com.HMS.HealthCare.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Doctorspecilization {
    
    @Id
    private Long id;

    private String specilization;
    private String creationdate;
    private String updationdate;

    public Doctorspecilization() {}

    public Doctorspecilization(Long id, String specilization, String creationdate, String updationdate) {
        this.id = id;
        this.specilization = specilization;
        this.creationdate = creationdate;
        this.updationdate = updationdate;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getSpecilization() {
        return specilization;
    }
    public void setSpecilization(String specilization) {
        this.specilization = specilization;
    }
    public String getCreationdate() {
        return creationdate;
    }
    public void setCreationdate(String creationdate) {
        this.creationdate = creationdate;
    }
    public String getUpdationdate() {
        return updationdate;
    }
    public void setUpdationdate(String updationdate) {
        this.updationdate = updationdate;
    }

    

}
