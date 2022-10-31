package com.HMS.HealthCare.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tblmedicalhistory {
    
    @Id
    private Long id;

    private Long patientid;
    private String bloodpressure;
    private String bloodsugar;
    private String weight;
    private String temperature;
    private String medicalpres;
    private String creationdate;

    
    public Tblmedicalhistory() {}

    public Tblmedicalhistory(Long id, Long patientid, String bloodpressure, String bloodsugar, String weight,
            String temperature, String medicalpres, String creationdate) {
        this.id = id;
        this.patientid = patientid;
        this.bloodpressure = bloodpressure;
        this.bloodsugar = bloodsugar;
        this.weight = weight;
        this.temperature = temperature;
        this.medicalpres = medicalpres;
        this.creationdate = creationdate;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getPatientid() {
        return patientid;
    }
    public void setPatientid(Long patientid) {
        this.patientid = patientid;
    }
    public String getBloodpressure() {
        return bloodpressure;
    }
    public void setBloodpressure(String bloodpressure) {
        this.bloodpressure = bloodpressure;
    }
    public String getBloodsugar() {
        return bloodsugar;
    }
    public void setBloodsugar(String bloodsugar) {
        this.bloodsugar = bloodsugar;
    }
    public String getWeight() {
        return weight;
    }
    public void setWeight(String weight) {
        this.weight = weight;
    }
    public String getTemperature() {
        return temperature;
    }
    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }
    public String getMedicalpres() {
        return medicalpres;
    }
    public void setMedicalpres(String medicalpres) {
        this.medicalpres = medicalpres;
    }
    public String getCreationdate() {
        return creationdate;
    }
    public void setCreationdate(String creationdate) {
        this.creationdate = creationdate;
    }

    

}
