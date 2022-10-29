package com.HMS.HealthCare.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.HMS.HealthCare.Entity.Doctor;

@Controller
@RequestMapping("")
public class DoctorController {
    
    @GetMapping("/hms/doctor")
    public String getDoctorLoginPage(Model model) {
        Doctor doctor = new Doctor();
        model.addAttribute("doctor", doctor);
        return "hms/doctor/index";
    }

    @PostMapping("/login-doctor")
    public String getDoctorDashboard() {
        return "hms/doctor/dashboard";
    }

    @GetMapping("/hms/doctor/dashboard") 
    public String getDashboard() {
        return "hms/doctor/dashboard";
    }

    @GetMapping("/hms/doctor/forgot-password")
    public String getForgotPassword() {
        return "hms/doctor/forgot-password";
    }

    @GetMapping("/hms/doctor/appointment-history")
    public String getAppointmentHistory() {
        return "hms/doctor/appointment-history";
    }

    @GetMapping("/hms/doctor/add-patient")
    public String getAddPatient() {
        return "hms/doctor/add-patient";
    }

    @GetMapping("/hms/doctor/manage-patient")
    public String getManagePatient() {
        return "hms/doctor/manage-patient";
    }

    @GetMapping("/hms/doctor/search")
    public String getSearch() {
        return "hms/doctor/search";
    }

    @GetMapping("/hms/doctor/edit-profile")
    public String getEditProfile() {
        return "hms/doctor/edit-profile";
    }

    @GetMapping("/hms/doctor/change-password")
    public String getChangePassword() {
        return "hms/doctor/change-password";
    }

    @GetMapping("/hms/doctor/view-patient")
    public String getViewPatient() {
        return "hms/doctor/view-patient";
    }

    @GetMapping("/hms/doctor/edit-patient")
    public String getEditPatient() {
        return "hms/doctor/edit-patient";
    }

}
