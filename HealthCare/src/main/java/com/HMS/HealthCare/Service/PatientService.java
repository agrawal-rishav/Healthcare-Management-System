package com.HMS.HealthCare.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HMS.HealthCare.Entity.Tblpatient;
import com.HMS.HealthCare.Repository.PatientRepository;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<Tblpatient> getAllPatients() {
        Iterable<Tblpatient> it = patientRepository.findAll();
        List<Tblpatient> li = new ArrayList<>();
        it.forEach(li :: add);
        return li;
    }

    public void deletePatientById(Long id) {
        patientRepository.deleteById(id);
    }

    public Tblpatient getPatientById(Long id) {
        return patientRepository.findById(id).get();
    }
    
}
