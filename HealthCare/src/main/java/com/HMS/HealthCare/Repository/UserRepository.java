package com.HMS.HealthCare.Repository;

import org.springframework.data.repository.CrudRepository;

import com.HMS.HealthCare.Entity.Users;

public interface UserRepository extends CrudRepository<Users, Long> {
    
}
