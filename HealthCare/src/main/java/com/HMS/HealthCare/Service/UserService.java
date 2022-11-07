package com.HMS.HealthCare.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.catalina.User;
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
        Users user = userRepository.findById(id).get();
        return user == null ? null : user;
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

    public boolean addUser(Users user) {
        List<Users> li = getAllUsers();
        for(Users use : li) {
            if(use.getEmail().equalsIgnoreCase(user.getEmail()))
                return false;
        }
        user.setRegdate(getCurrentTimestamp());
        user.setUpdationdate(getCurrentTimestamp());
        long maxId = 0;
        for(Users u : li) {
            if(u.getId() > maxId)
                maxId = u.getId() + 1;
        }
        user.setId(maxId);
        userRepository.save(user);
        return true;
    }

    public String getCurrentTimestamp() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        return formatter.format(date).toString();
    }

}
