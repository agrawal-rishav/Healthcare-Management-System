package com.HMS.HealthCare.Service;

import java.util.ArrayList;
import java.util.Date;
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

    public List<Tblpatient> getPatientsByDate(String fromdate, String todate) {
        List<Tblpatient> li = getAllPatients();
        String from[] = fromdate.split("-");
        String to[] = todate.split("-");
        List<Tblpatient> ans = new ArrayList<>();
        for(int i=0; i<li.size(); i++) {
            String s[] = li.get(i).getCreationdate().split(" ");
            String data[] = s[0].split("-");
            if((Integer.valueOf(data[0]) >= Integer.valueOf(from[0])  &&  Integer.valueOf(data[0]) <= Integer.valueOf(to[0]))
                 && (Integer.valueOf(data[1]) >= Integer.valueOf(from[1])  &&  Integer.valueOf(data[1]) <= Integer.valueOf(to[1]))
                 && (Integer.valueOf(data[2]) >= Integer.valueOf(from[2])  &&  Integer.valueOf(data[2]) <= Integer.valueOf(to[1]))) {
                    ans.add(li.get(i));
                 }

        }
        return ans;
    }

    public List<Tblpatient> getPatientBynameOrNumber(String search) {
        List<Tblpatient> li = getAllPatients();
        List<Tblpatient> ans = new ArrayList<>();
        for(Tblpatient patient : li) {
            String phone = String.valueOf(patient.getPatientcontno());
            if(search.equals(phone)  ||  search.equalsIgnoreCase(patient.getPatientname())) 
                ans.add(patient); 
        }
        return ans;
    }
    
}
