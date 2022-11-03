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

    public Users getUserByEmail(String email, String password) {
        List<Users> li = getAllUsers();
        for(Users user : li) {
            if(email.equalsIgnoreCase(user.getEmail())  &&  password.equals(user.getPassword()))
                return user;
        }
        return null;
    }

    public void updateUser(Users user, Long id) {
        Users use = userRepository.findById(id).get();
        use.setAddress(user.getAddress());
        use.setCity(user.getCity());
        use.setFullname(user.getFullname());
        userRepository.save(use);
    }

}
