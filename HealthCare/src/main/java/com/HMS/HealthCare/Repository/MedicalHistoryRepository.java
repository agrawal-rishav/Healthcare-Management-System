package com.HMS.HealthCare.Repository;

import org.springframework.data.repository.CrudRepository;

import com.HMS.HealthCare.Entity.Tblmedicalhistory;

public interface MedicalHistoryRepository extends CrudRepository<Tblmedicalhistory, Long> {
    
}
