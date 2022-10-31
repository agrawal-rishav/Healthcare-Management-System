package com.HMS.HealthCare.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tblpatient {
    
    @Id
    private Long id;
    
    private Long docid;
    private String patientname;
    private String patientemail;
    private String patientgender;
    private String patientadd;
    private Integer patientage;
    private String patientmedhis;
    private String creationdate;
    private String updationdate;
    private Long patientcontno;

    public Tblpatient() {}

    public Tblpatient(Long id, Long docid, String patientname, Long patientcontno, String patientemail,
            String patientgender, String patientadd, Integer patientage, String patientmedhis, String creationdate,
            String updationdate) {
        this.id = id;
        this.docid = docid;
        this.patientname = patientname;
        this.patientcontno = patientcontno;
        this.patientemail = patientemail;
        this.patientgender = patientgender;
        this.patientadd = patientadd;
        this.patientage = patientage;
        this.patientmedhis = patientmedhis;
        this.creationdate = creationdate;
        this.updationdate = updationdate;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getDocid() {
        return docid;
    }
    public void setDocid(Long docid) {
        this.docid = docid;
    }
    public String getPatientname() {
        return patientname;
    }
    public void setPatientname(String patientname) {
        this.patientname = patientname;
    }
    public String getPatientemail() {
        return patientemail;
    }
    public void setPatientemail(String patientemail) {
        this.patientemail = patientemail;
    }
    public String getPatientgender() {
        return patientgender;
    }
    public void setPatientgender(String patientgender) {
        this.patientgender = patientgender;
    }
    public String getPatientadd() {
        return patientadd;
    }
    public void setPatientadd(String patientadd) {
        this.patientadd = patientadd;
    }
    public Integer getPatientage() {
        return patientage;
    }
    public void setPatientage(Integer patientage) {
        this.patientage = patientage;
    }
    public String getPatientmedhis() {
        return patientmedhis;
    }
    public void setPatientmedhis(String patientmedhis) {
        this.patientmedhis = patientmedhis;
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

    public Long getPatientcontno() {
        return patientcontno;
    }

    public void setPatientcontno(Long patientcontno) {
        this.patientcontno = patientcontno;
    }

}
