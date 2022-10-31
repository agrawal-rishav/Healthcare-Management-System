package com.HMS.HealthCare.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Doctors {
    
    @Id
    private Long id;

    private String specilization;
    private String doctorname;
    private String address;
    private Long docfees;
    private String contactno;
    private String docemail;
    private String password;
    private String creationdate;
    private String updationdate;

    public Doctors() {}

    public Doctors(Long id, String specilization, String doctorname, String address, Long docfees, String contactno,
            String docemail, String password, String creationdate, String updationdate) {
        this.id = id;
        this.specilization = specilization;
        this.doctorname = doctorname;
        this.address = address;
        this.docfees = docfees;
        this.contactno = contactno;
        this.docemail = docemail;
        this.password = password;
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
    public String getDoctorname() {
        return doctorname;
    }
    public void setDoctorname(String doctorname) {
        this.doctorname = doctorname;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Long getDocfees() {
        return docfees;
    }
    public void setDocfees(Long docfees) {
        this.docfees = docfees;
    }
    public String getContactno() {
        return contactno;
    }
    public void setContactno(String contactno) {
        this.contactno = contactno;
    }
    public String getDocemail() {
        return docemail;
    }
    public void setDocemail(String docemail) {
        this.docemail = docemail;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
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
