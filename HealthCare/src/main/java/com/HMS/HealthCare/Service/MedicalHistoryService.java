package com.HMS.HealthCare.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HMS.HealthCare.Entity.Tblmedicalhistory;
import com.HMS.HealthCare.Repository.MedicalHistoryRepository;

@Service
public class MedicalHistoryService {
    
    @Autowired
    private MedicalHistoryRepository medicalHistoryRepository;



    public List<Tblmedicalhistory> getMedicalHistoryById(Long id) {
        List<Tblmedicalhistory> li = new ArrayList<>();
        Iterable<Tblmedicalhistory> it = medicalHistoryRepository.findAll();
        for(Tblmedicalhistory history : it) {
            if(history.getPatientid() == id) 
                li.add(history);
        }
        return li;
    }

}
