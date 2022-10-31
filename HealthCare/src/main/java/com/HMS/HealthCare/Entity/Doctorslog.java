package com.HMS.HealthCare.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.OptimisticLocking;

@Entity
public class Doctorslog {
    
    @Id
    private Long id;

    private Long uid;
    private String usename;
    private String userip;
    private String logintime;
    private String logout;
    private Integer status;

    public Doctorslog() {}
    
    public Doctorslog(Long id, Long uid, String usename, String userip, String logintime, String logout,
            Integer status) {
        this.id = id;
        this.uid = uid;
        this.usename = usename;
        this.userip = userip;
        this.logintime = logintime;
        this.logout = logout;
        this.status = status;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getUid() {
        return uid;
    }
    public void setUid(Long uid) {
        this.uid = uid;
    }
    public String getUsename() {
        return usename;
    }
    public void setUsename(String usename) {
        this.usename = usename;
    }
    public String getUserip() {
        return userip;
    }
    public void setUserip(String userip) {
        this.userip = userip;
    }
    public String getLogintime() {
        return logintime;
    }
    public void setLogintime(String logintime) {
        this.logintime = logintime;
    }
    public String getLogout() {
        return logout;
    }
    public void setLogout(String logout) {
        this.logout = logout;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }

    

}
