package com.HMS.HealthCare.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HMS.HealthCare.Entity.Doctors;

@Service
public class DoctorDtoService {

    @Autowired
    DoctorService doctorService;

    public Doctors getById(Long id) {
        return doctorService.getDoctorById(id);
    }
}
