package com.HMS.HealthCare.DTO;

public class DoctorDto {
    
    private Long id;
    private String specilization;
    private String docname;
    private String address;
    private Long fees;
    private String contactno;
    private String email;
    private String password;

    

    public DoctorDto(Long id, String specilization, String docname, String address, Long fees, String contactno,
            String email, String password) {
        this.id = id;
        this.specilization = specilization;
        this.docname = docname;
        this.address = address;
        this.fees = fees;
        this.contactno = contactno;
        this.email = email;
        this.password = password;
    }

    public DoctorDto() {}
    
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
    public String getDocname() {
        return docname;
    }
    public void setDocname(String docname) {
        this.docname = docname;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Long getFees() {
        return fees;
    }
    public void setFees(Long fees) {
        this.fees = fees;
    }
    public String getContactno() {
        return contactno;
    }
    public void setContactno(String contactno) {
        this.contactno = contactno;
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

    @Override
    public String toString() {
        return "DoctorDto [id=" + id + ", specilization=" + specilization + ", docname=" + docname + ", address="
                + address + ", fees=" + fees + ", contactno=" + contactno + ", email=" + email + ", password="
                + password + "]";
    }    

    

}
