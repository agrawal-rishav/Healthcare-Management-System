package com.HMS.HealthCare.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HMS.HealthCare.Entity.Users;
import com.HMS.HealthCare.Repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public List<Users> getAllUsers() {
        Iterable<Users> it = userRepository.findAll();
        List<Users> li = new ArrayList<>();
        it.forEach(li :: add);
        return li;
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    public Users getUserById(Long id) {
        return userRepository.findById(id).get();
    }

}
