package com.HMS.HealthCare.Service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HMS.HealthCare.Entity.Doctorslog;
import com.HMS.HealthCare.Repository.DoctorslogRepository;

@Service
public class DoctorslogService {
    
    @Autowired
    private DoctorslogRepository doctorslogRepository;

    public List<Doctorslog> getAllDoctors() {
        Iterable<Doctorslog> it = doctorslogRepository.findAll();
        List<Doctorslog> li = new ArrayList<>();
        it.forEach(li :: add);
        return li;
    }

}
