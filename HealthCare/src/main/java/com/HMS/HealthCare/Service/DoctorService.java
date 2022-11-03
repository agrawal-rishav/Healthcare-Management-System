package com.HMS.HealthCare.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HMS.HealthCare.DTO.DoctorDto;
import com.HMS.HealthCare.Entity.Doctor;
import com.HMS.HealthCare.Entity.Doctors;
import com.HMS.HealthCare.Repository.DoctorRepository;

@Service
public class DoctorService {
    
    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctors> getAllDoctors() {
        List<Doctors> doctor = new ArrayList<>();
        doctorRepository.findAll().forEach(doctors -> doctor.add(doctors));
        return doctor;
    }

    public void removeDoctor(Long id) {
        doctorRepository.deleteById(id);
    }

    public Doctors getDoctorById(Long id) {
        Optional<Doctors> option = doctorRepository.findById(id);
        return option.get();
    }

    public List<Doctors> getDoctorBySpecialization(String specialization) {
        Iterable<Doctors> it = doctorRepository.findAll();
        List<Doctors> li = new ArrayList<>();
        for(Doctors d : it) {
            if(specialization.equalsIgnoreCase(d.getSpecilization()))
                li.add(d);
        }
        return li;
    }

    public Doctors getDoctorByUsernameAndPassword(String username, String password) {
        List<Doctors> li = getAllDoctors();
        for(Doctors doctor : li) {
            if(doctor.getDocemail().equalsIgnoreCase(username)  &&  doctor.getPassword().equals(password))
                return doctor;
        }
        return null;
    }

    public void updateDoctorById(DoctorDto doctordto, Long id) {
        Optional<Doctors> option = doctorRepository.findById(id);
        Doctors doctor = option.get();
        doctor.setId(id);
        doctor.setAddress(doctordto.getAddress());
        doctor.setContactno(doctordto.getContactno());
        doctor.setDocemail(doctordto.getEmail());
        doctor.setDoctorname(doctordto.getDocname());
        doctor.setDocfees(doctordto.getFees());
        doctor.setSpecilization(doctordto.getSpecilization());
        doctor.setUpdationdate(getCurrentTimestamp());

        doctorRepository.save(doctor);
    }


    public boolean checkEmailAvailability(String username) {
        Iterable<Doctors> it = doctorRepository.findAll();
        for(Doctors d : it) {
            if(d.getDocemail().equalsIgnoreCase(username))
                return true;
        }
        return false;
    }

    public void saveDoctor(DoctorDto doctordto) {
        Iterable<Doctors> it = doctorRepository.findAll();
        long maxId = 0l;
        for(Doctors d : it) {
            maxId = Math.max(maxId, d.getId());
        }
        Doctors doctor = new Doctors();
        doctor.setId(maxId+1);
        doctor.setAddress(doctordto.getAddress());
        doctor.setContactno(doctordto.getContactno());
        doctor.setDocemail(doctordto.getEmail());
        doctor.setDoctorname(doctordto.getDocname());
        doctor.setDocfees(doctordto.getFees());
        doctor.setSpecilization(doctordto.getSpecilization());
        doctor.setPassword(doctordto.getPassword());
        doctor.setCreationdate(getCurrentTimestamp());
        doctor.setUpdationdate(getCurrentTimestamp());
        doctorRepository.save(doctor);
    }

    public String getCurrentTimestamp() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        return formatter.format(date).toString();
    }
}
