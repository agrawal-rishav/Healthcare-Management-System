package com.HMS.HealthCare.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Userlog {
    
    @Id
    private Long id;
    
    private Long uid;
    private String username;
    private String userip;
    private String logintime;
    private String logout;
    private Integer status;

    public Userlog() {}
    
    public Userlog(Long id, Long uid, String username, String userip, String logintime, String logout, Integer status) {
        this.id = id;
        this.uid = uid;
        this.username = username;
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
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
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
