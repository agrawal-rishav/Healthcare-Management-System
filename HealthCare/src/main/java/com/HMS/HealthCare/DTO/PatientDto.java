package com.HMS.HealthCare.DTO;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PatientDto {

    @Id
    private Long id;

    private String name;
    private Long contno;
    private String email;
    private String gender;
    private String address;
    private Integer age;
    private String medhistory;

    
    

    public PatientDto() {}


    public PatientDto(String name, Long contno, String email, String gender, String address, Integer age,
            String medhistory) {
        this.name = name;
        this.contno = contno;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.age = age;
        this.medhistory = medhistory;
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getContno() {
        return contno;
    }
    public void setContno(Long contno) {
        this.contno = contno;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public String getMedhistory() {
        return medhistory;
    }
    public void setMedhistory(String medhistory) {
        this.medhistory = medhistory;
    }

    

}
