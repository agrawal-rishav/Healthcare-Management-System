package com.HMS.HealthCare.Repository;

import org.springframework.data.repository.CrudRepository;

import com.HMS.HealthCare.Entity.Appointment;

public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
    
}
