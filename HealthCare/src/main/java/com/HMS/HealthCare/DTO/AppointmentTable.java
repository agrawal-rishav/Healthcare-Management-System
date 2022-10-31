package com.HMS.HealthCare.DTO;

public class AppointmentTable {
    
    private Long id;
    private String doctorname;
    private String patientname;
    private String specialization;
    private String fees;
    private String appointmentdatetime;
    private String appointmentcreationdate;
    private String status;
    private String action;

    

    public AppointmentTable() {}

    

    public AppointmentTable(Long count, String doctorname, String patientname, String specialization, String fees,
            String appointmentdatetime, String appointmentcreationdate, String status, String action) {
        this.id = count;
        this.doctorname = doctorname;
        this.patientname = patientname;
        this.specialization = specialization;
        this.fees = fees;
        this.appointmentdatetime = appointmentdatetime;
        this.appointmentcreationdate = appointmentcreationdate;
        this.status = status;
        this.action = action;
    }



    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDoctorname() {
        return doctorname;
    }
    public void setDoctorname(String doctorname) {
        this.doctorname = doctorname;
    }
    public String getPatientname() {
        return patientname;
    }
    public void setPatientname(String patientname) {
        this.patientname = patientname;
    }
    public String getSpecialization() {
        return specialization;
    }
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
    public String getFees() {
        return fees;
    }
    public void setFees(String fees) {
        this.fees = fees;
    }
    public String getAppointmentdatetime() {
        return appointmentdatetime;
    }
    public void setAppointmentdatetime(String appointmentdatetime) {
        this.appointmentdatetime = appointmentdatetime;
    }
    public String getAppointmentcreationdate() {
        return appointmentcreationdate;
    }
    public void setAppointmentcreationdate(String appointmentcreationdate) {
        this.appointmentcreationdate = appointmentcreationdate;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getAction() {
        return action;
    }
    public void setAction(String action) {
        this.action = action;
    }

    
    
}
