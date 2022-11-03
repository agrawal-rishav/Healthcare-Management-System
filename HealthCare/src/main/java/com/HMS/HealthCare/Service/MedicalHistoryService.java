package com.HMS.HealthCare.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    public void saveHistory(Long patientid, String bp, String bs, String weight, String temp, String pres) {
        long id = 10l;
        while(medicalHistoryRepository.findById(id++) == null);
        Tblmedicalhistory history = new Tblmedicalhistory(id, patientid, bp, bs, weight, temp, pres, getCurrentTimestamp());
        medicalHistoryRepository.save(history);
    }

    public String getCurrentTimestamp() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        return formatter.format(date).toString();
    }

}
