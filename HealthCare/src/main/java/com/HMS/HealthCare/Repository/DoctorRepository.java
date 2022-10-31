package com.HMS.HealthCare.Repository;

import org.springframework.data.repository.CrudRepository;

import com.HMS.HealthCare.Entity.Doctors;

public interface DoctorRepository extends CrudRepository<Doctors, Long> {
    
}
