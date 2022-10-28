package com.HMS.HealthCare.Service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HMS.HealthCare.Entity.Admin;
import com.HMS.HealthCare.Repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {
    
    @Autowired
    AdminRepository adminRepository;

    @Override
    public Admin saveAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public List<Admin> fetchAdminList() {
        return (List<Admin>)adminRepository.findAll();
    }

    @Override
    public Admin updateAdmin(Admin admin, Long adminId) {
        Admin adDb = adminRepository.findById(adminId).get();
        if(Objects.nonNull(admin.getUsername())) {
            adDb.setUsername(admin.getUsername());
        }
        if(Objects.nonNull(admin.getPassword())) {
            adDb.setPassword(admin.getPassword());
        }
        return adminRepository.save(adDb);
    }

    @Override
    public void deleteAdminById(Long adminId) {
        adminRepository.deleteById(adminId);
    } 
}
