package com.HMS.HealthCare.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HMS.HealthCare.Entity.Appointment;
import com.HMS.HealthCare.Repository.AppointmentRepository;

@Service
public class AppointmentService {
    
    @Autowired
    AppointmentRepository appointmentRepository;
    
    public List<Appointment> getAllAppointments() {
        Iterable<Appointment> it = appointmentRepository.findAll();
        List<Appointment> li = new ArrayList<>();
        it.forEach(li :: add);
        return li;
    }

}
