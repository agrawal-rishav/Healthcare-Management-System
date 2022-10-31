package com.HMS.HealthCare.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tblcontactus {
    
    @Id
    private Long id;

    private String fullname;
    private String email;
    private Long contactno;
    private String message;
    private String postingdate;
    private String adminremark;
    private String lastupdationdate;
    private Integer isread;

    public Tblcontactus() {}
    
    public Tblcontactus(Long id, String fullname, String email, Long contactno, String message, String postingdate,
            String adminremark, String lastupdationdate, Integer isread) {
        this.id = id;
        this.fullname = fullname;
        this.email = email;
        this.contactno = contactno;
        this.message = message;
        this.postingdate = postingdate;
        this.adminremark = adminremark;
        this.lastupdationdate = lastupdationdate;
        this.isread = isread;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFullname() {
        return fullname;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Long getContactno() {
        return contactno;
    }
    public void setContactno(Long contactno) {
        this.contactno = contactno;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getPostingdate() {
        return postingdate;
    }
    public void setPostingdate(String postingdate) {
        this.postingdate = postingdate;
    }
    public String getAdminremark() {
        return adminremark;
    }
    public void setAdminremark(String adminremark) {
        this.adminremark = adminremark;
    }
    public String getLastupdationdate() {
        return lastupdationdate;
    }
    public void setLastupdationdate(String lastupdationdate) {
        this.lastupdationdate = lastupdationdate;
    }
    public Integer getIsread() {
        return isread;
    }
    public void setIsread(Integer isread) {
        this.isread = isread;
    }

    

}
