package com.HMS.HealthCare.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.HMS.HealthCare.Entity.Patient;

@Controller
public class PatientController {
    
    @GetMapping("/hms/patient")
    public String getPatientLoginpage(Model model) {
        Patient patient = new Patient();
        model.addAttribute("patient", patient);
        return "hms/user-login";
    }

    @PostMapping("/login-patient")
    public String getPatientDashboard() {
        return "hms/dashboard";
    }

    @GetMapping("/hms/dashboard")
    public String getDashboard() {
        return "hms/dashboard";
    }

    @GetMapping("/hms/book-appointment")
    public String getBookAppointment() {
        return "hms/book-appointment";
    }

    @GetMapping("/hms/appointment-history")
    public String getAppointmentHistory() {
        return "hms/appointment-history";
    }

    @GetMapping("/hms/view-medhistory")
    public String getViewMedhistory() {
        return "hms/view-medhistory";
    }

    @GetMapping("/hms/edit-profile")
    public String getEditProfile() {
        return "hms/edit-profile";
    }

    @GetMapping("/hms/change-password")
    public String getChangePassword() {
        return "hms/change-password";
    }

    @GetMapping("/hms/forgot-password")
    public String getForgotPassword() {
        return "hms/forgot-password";
    }

    @GetMapping("/hms/registeration")
    public String getRegisteration() {
        return "hms/registeration";
    }

}
