package com.HMS.HealthCare.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Appointment {
    
    @Id
    Long ID;

    private String doctorspecialization;
    private String doctorid;
    private String userid;
    private String consultancyfees;
    private String appointmenttime;
    private String appointmentdate;
    private String postingdate;
    private String userstatus;
    private String doctorstatus;
    private String updationdate;


    public Appointment() {}

    public Appointment(Long iD, String doctorspecialization, String doctorid, String userid, String consultancyfees,
            String appointmenttime, String appointmentdate, String postingdate, String userstatus, String doctorstatus,
            String updationdate) {
        ID = iD;
        this.doctorspecialization = doctorspecialization;
        this.doctorid = doctorid;
        this.userid = userid;
        this.consultancyfees = consultancyfees;
        this.appointmenttime = appointmenttime;
        this.appointmentdate = appointmentdate;
        this.postingdate = postingdate;
        this.userstatus = userstatus;
        this.doctorstatus = doctorstatus;
        this.updationdate = updationdate;
    }
    public Long getID() {
        return ID;
    }
    public void setID(Long iD) {
        ID = iD;
    }
    public String getDoctorspecialization() {
        return doctorspecialization;
    }
    public void setDoctorspecialization(String doctorspecialization) {
        this.doctorspecialization = doctorspecialization;
    }
    public String getDoctorid() {
        return doctorid;
    }
    public void setDoctorid(String doctorid) {
        this.doctorid = doctorid;
    }
    public String getUserid() {
        return userid;
    }
    public void setUserid(String userid) {
        this.userid = userid;
    }
    public String getAppointmenttime() {
        return appointmenttime;
    }
    public void setAppointmenttime(String appointmenttime) {
        this.appointmenttime = appointmenttime;
    }
    public String getAppointmentdate() {
        return appointmentdate;
    }
    public void setAppointmentdate(String appointmentdate) {
        this.appointmentdate = appointmentdate;
    }
    public String getPostingdate() {
        return postingdate;
    }
    public void setPostingdate(String postingdate) {
        this.postingdate = postingdate;
    }
    public String getUserstatus() {
        return userstatus;
    }
    public void setUserstatus(String userstatus) {
        this.userstatus = userstatus;
    }
    public String getDoctorstatus() {
        return doctorstatus;
    }
    public void setDoctorstatus(String doctorstatus) {
        this.doctorstatus = doctorstatus;
    }
    public String getUpdationdate() {
        return updationdate;
    }
    public void setUpdationdate(String updationdate) {
        this.updationdate = updationdate;
    }

    public String getConsultancyfees() {
        return consultancyfees;
    }

    public void setConsultancyfees(String consultancyfees) {
        this.consultancyfees = consultancyfees;
    }
    

}
