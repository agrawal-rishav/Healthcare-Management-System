package com.HMS.HealthCare.Service;

import java.util.List;

import com.HMS.HealthCare.Entity.Admin;

public interface AdminService {
    
    Admin saveAdmin(Admin admin);
    List<Admin> fetchAdminList();
    Admin updateAdmin(Admin admin, Long adminId);
    void deleteAdminById(Long adminId);

}
