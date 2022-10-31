package com.HMS.HealthCare.Repository;

import org.springframework.data.repository.CrudRepository;

import com.HMS.HealthCare.Entity.Tblpatient;

public interface PatientRepository extends CrudRepository<Tblpatient, Long> {
    
}
