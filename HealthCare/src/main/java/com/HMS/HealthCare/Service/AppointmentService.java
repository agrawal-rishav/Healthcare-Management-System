package com.HMS.HealthCare.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HMS.HealthCare.Entity.Appointment;
import com.HMS.HealthCare.Entity.Doctors;
import com.HMS.HealthCare.Repository.AppointmentRepository;

@Service
public class AppointmentService {
    
    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    DoctorService doctorService;
    
    public List<Appointment> getAllAppointments() {
        Iterable<Appointment> it = appointmentRepository.findAll();
        List<Appointment> li = new ArrayList<>();
        it.forEach(li :: add);
        return li;
    }

    public void addAppointment(String special, String fees, String date, String time, Long id) {
        List<Doctors> doctor = doctorService.getDoctorBySpecialization(special);
        Appointment app = new Appointment(0l, special, String.valueOf(doctor.get(0).getId()), String.valueOf(id), fees, time, date, getCurrentTimestamp(), "1" , "1" ,"1");
        appointmentRepository.save(app);
    }
    
    public String getCurrentTimestamp() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        return formatter.format(date).toString();
    }

}
