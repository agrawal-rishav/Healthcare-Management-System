package com.HMS.HealthCare.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.HMS.HealthCare.Entity.Admin;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Long> {
    
    public boolean existsByUsername(String email);

    public Admin findByUsername(String email);
}
