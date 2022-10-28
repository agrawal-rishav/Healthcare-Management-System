package com.HMS.HealthCare.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.HMS.HealthCare.Entity.Admin;
import com.HMS.HealthCare.Entity.Contact;
import com.HMS.HealthCare.Repository.AdminRepository;

@Controller
//@RequestMapping("/hms/admin")
public class AdminController {

     @Autowired
     AdminRepository adminRepository;

    @GetMapping("/hms/admin")
    public String getAdminLoginPage(Model model) {
        Admin admin = new Admin();
        model.addAttribute("admin", admin);
        return "hms/admin/index";
    }
    
    @PostMapping("/login-admin")
    public String getAdminDashboard(HttpServletRequest request) {
        return "hms/admin/dashboard";
    }
    

   @GetMapping("/hms/admin/doctor-specilization")
   public String getDoctorSpecilization() {
        return "hms/admin/doctor-specilization";
   }

   @GetMapping("/hms/admin/dashboard")
   public String getDashboard() {
    return "hms/admin/dashboard";
   }

   @GetMapping("/hms/admin/add-doctor")
   public String getAddDoctor(Model model) {
    List<String> specials = new ArrayList<>(Arrays.asList("Gynaecologist", "Genral Physician", "Dermatologist", "Homeopath", "Ayurveda", "Dentist", "ENT Specialist", "Demo Test", "Bones Specialist"));
    model.addAttribute("options", specials);
        return "hms/admin/add-doctor";
   }

   @GetMapping("/hms/admin/manage-doctors") 
   public String getManageDoctors() {
        return "hms/admin/manage-doctors";
   }

   @GetMapping("/hms/admin/manage-users")
   public String getManageUsers() {
        return "hms/admin/manage-users";
   }
    
   @GetMapping("/hms/admin/manage-patient")
   public String getManagePatient() {
        return "hms/admin/manage-patient";
   }

   @GetMapping("/hms/admin/appointment-history")
   public String getAppointmentHistory() {
        return "hms/admin/appointment-history";
   }

   @GetMapping("/hms/admin/unread-queries")
   public String getUnreadQueries() {
        return "hms/admin/unread-queries";
   }

   @GetMapping("/hms/admin/read-query")
   public String getReadQuery() {
        return "hms/admin/read-query";
   }

   @GetMapping("/hms/admin/doctor-logs")
   public String getDoctorLogs() {
        return "hms/admin/doctor-logs";
   }

   @GetMapping("/hms/admin/user-logs")
   public String getUserLogs() {
        return "hms/admin/user-logs";
   }

   @GetMapping("/hms/admin/between-dates-reports")
   public String getBetweenDatesReports() {
        return "hms/admin/between-dates-reports";
   }

   @GetMapping("/hms/admin/patient-search")
   public String getPatientSearch() {
        return "hms/admin/patient-search";
   }
}
