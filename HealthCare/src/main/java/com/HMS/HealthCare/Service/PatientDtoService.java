package com.HMS.HealthCare.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HMS.HealthCare.DTO.PatientDto;
import com.HMS.HealthCare.Entity.Tblpatient;

@Service
public class PatientDtoService {
    
    @Autowired
    private PatientService patientService;

    public boolean addPatient(PatientDto patientdto, Long id) {
        List<Tblpatient> li = patientService.getAllPatients();
        Long maxId = Long.MIN_VALUE;
        for(Tblpatient patient : li) {
            if(patient.getPatientemail().equalsIgnoreCase(patientdto.getEmail())) {
                return false;
            }
            if(patient.getId() > maxId)
                maxId = patient.getId();
        }
        Tblpatient patient = new Tblpatient(maxId+1, id, patientdto.getName(), patientdto.getContno(),
                                            patientdto.getEmail(), patientdto.getGender(), patientdto.getAddress(),
                                            patientdto.getAge(), patientdto.getMedhistory(), getCurrentTimestamp(), getCurrentTimestamp());
        patientService.savePatient(patient);
        return true;
    }

    public void updatePatient(PatientDto patientdto, Long patientId, Long doctorId) {
        Tblpatient patient = patientService.getPatientById(patientId);
        patient = new Tblpatient(patientId, doctorId, patientdto.getName(), patientdto.getContno(),
                                            patientdto.getEmail(), patientdto.getGender(), patientdto.getAddress(),
                                            patientdto.getAge(), patientdto.getMedhistory(), getCurrentTimestamp(), getCurrentTimestamp());
        patientService.savePatient(patient);
    }

    public String getCurrentTimestamp() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        return formatter.format(date).toString();
    }

}
