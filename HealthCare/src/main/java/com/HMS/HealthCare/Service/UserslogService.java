package com.HMS.HealthCare.Service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HMS.HealthCare.Entity.Userlog;
import com.HMS.HealthCare.Repository.UserslogRepository;

@Service
public class UserslogService {

    @Autowired
    private UserslogRepository userslogRepository;

    public List<Userlog> getAllUsers() {
        Iterable<Userlog> it = userslogRepository.findAll();
        List<Userlog> li = new ArrayList<>();
        it.forEach(li :: add);
        return li;
    }
    
}
