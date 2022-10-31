package com.HMS.HealthCare.Entity;

import javax.validation.constraints.NotNull;

import net.bytebuddy.implementation.bytecode.assign.reference.GenericTypeAwareAssigner;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


public class PatientDto {

        @Id
        @GeneratedValue
        private UUID id;

        @NotNull
        @NotEmpty(message = "Name cannot be empty")
        private String fullName;

        @NotNull
        @NotEmpty(message = "Address cannot be empty")
        private String address;

        @NotNull
        @NotEmpty(message = "City cannot be empty")
        private String city;

        @NotNull
        @NotEmpty(message = "Sex cannot be empty")
        private String sex;

        @NotNull
        @Email(message = "Email is not valid", regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
        @NotEmpty(message = "Email cannot be empty")
        private String username;

        @NotNull
        @NotEmpty(message = "Password cannot be empty")
        private String password;

        @NotNull
        @NotEmpty(message = "Passwords do not match")
        private String confirmPassword;


        public PatientDto() {}
        

        public PatientDto(@NotNull @NotEmpty String fullName, @NotNull @NotEmpty String address,
                @NotNull @NotEmpty String city, @NotNull @NotEmpty String sex,@NotNull @NotEmpty String username,
                @NotNull @NotEmpty String password, @NotNull @NotEmpty String confirmPassword) {
            this.fullName = fullName;
            this.address = address;
            this.city = city;
            this.sex = sex;
            this.username = username;
            this.password = password;
            this.confirmPassword = confirmPassword;
        } 
        
        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getConfirmPassword() {
            return confirmPassword;
        }

        public void setConfirmPassword(String confirmPassword) {
            this.confirmPassword = confirmPassword;
        }


        @Override
        public String toString() {
            return "PatientDto [fullName=" + fullName + ", address=" + address + ", city=" + city + ", sex=" + sex
                    + ", username=" + username + ", password=" + password + ", confirmPassword=" + confirmPassword + "]";
        }

        

}
