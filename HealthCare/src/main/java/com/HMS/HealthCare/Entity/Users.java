package com.HMS.HealthCare.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Users {
    
    @Id
    private Long id;

    private String fullname;
    private String address;
    private String city;
    private String gender;
    private String email;
    private String password;
    private String regdate;
    private String updationdate;

    

    public Users() {}

    public Users(Long id, String gender, String fullname, String address, String city, String email, String password,
            String regdate, String updationdate) {
        this.id = id;
        this.gender = gender;
        this.fullname = fullname;
        this.address = address;
        this.city = city;
        this.email = email;
        this.password = password;
        this.regdate = regdate;
        this.updationdate = updationdate;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getFullname() {
        return fullname;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getRegdate() {
        return regdate;
    }
    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }
    public String getUpdationdate() {
        return updationdate;
    }
    public void setUpdationdate(String updationdate) {
        this.updationdate = updationdate;
    }



    

}
