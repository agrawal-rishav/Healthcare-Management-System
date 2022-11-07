package com.HMS.HealthCare.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.HMS.HealthCare.Entity.Doctors;
import com.HMS.HealthCare.Entity.Patient;
import com.HMS.HealthCare.Entity.Tblmedicalhistory;
import com.HMS.HealthCare.Entity.Tblpatient;
import com.HMS.HealthCare.Entity.Users;
import com.HMS.HealthCare.Service.AppointmentService;
import com.HMS.HealthCare.Service.DoctorService;
import com.HMS.HealthCare.Service.MedicalHistoryService;
import com.HMS.HealthCare.Service.PatientService;
import com.HMS.HealthCare.Service.UserService;

@Controller
public class PatientController {

    @Autowired
    private UserService userService;
    @Autowired
    private PatientService patientService;
    @Autowired 
    private DoctorService doctorService;
    @Autowired
    private MedicalHistoryService medicalHistoryService;
    @Autowired
    private AppointmentService appointmentService;

    static Users user;

    
    @GetMapping("/hms/patient")
    public String getPatientLoginpage() {
        
        
        return "hms/user-login";
    }

    @PostMapping("/login-patient")
    public String getPatientDashboard(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        user = userService.getUserByEmail(username.trim(), password);
        if(user == null) {
            model.addAttribute("message", "Invalid username or password");
            return "hms/user-login";
        }
        model.addAttribute("username", user.getFullname());
        return "hms/dashboard";
    }

    @GetMapping("/hms/dashboard")
    public String getDashboard(Model model) {
        model.addAttribute("username", user.getFullname());
        return "hms/dashboard";
    }

    @GetMapping("/hms/book-appointment")
    public String getBookAppointment(Model model) {
        model.addAttribute("specialization", getDoctorSpecializationList());
        model.addAttribute("fees", 500);
        model.addAttribute("username", user.getFullname());
        return "hms/book-appointment";
    }

    @PostMapping("/hms/book-appointment")
    public String bookAppointment(@RequestParam("Doctorspecialization") String special, @RequestParam("fees") String fees, @RequestParam("appdate") String date, @RequestParam("apptime") String time , Model model) {
        appointmentService.addAppointment(special, fees, date, time, user.getId());
        model.addAttribute("username", user.getFullname());
        model.addAttribute("message", "Appointment booked successfully");
        return "/hms/book-appointment";
    }

    @GetMapping("/hms/appointment-history")
    public String getAppointmentHistory(Model model) {
        model.addAttribute("username", user.getFullname());
        return "hms/appointment-history";
    }

    @GetMapping("/hms/view-medhistory")
    public String getViewMedhistory(Model model) {
        Tblpatient patient = patientService.getPatientById(user.getId());
        if(patient == null) {
            return getDashboard(model);
        }
        List<Tblmedicalhistory> li = medicalHistoryService.getMedicalHistoryById(user.getId());
        model.addAttribute("name", patient.getPatientname());
        model.addAttribute("email", patient.getPatientemail());
        model.addAttribute("contactno", patient.getPatientcontno());
        model.addAttribute("gender", patient.getPatientgender());
        model.addAttribute("address", patient.getPatientadd());
        model.addAttribute("age", patient.getPatientage());
        model.addAttribute("history", patient.getPatientmedhis());
        model.addAttribute("regdate", patient.getCreationdate());
        model.addAttribute("history", li);
        model.addAttribute("username", user.getFullname());
        return "hms/view-medhistory";
    }

    @GetMapping("/hms/edit-profile")
    public String getEditProfile(Model model) {
        model.addAttribute("creationdate", user.getRegdate());
        model.addAttribute("updationdate", user.getUpdationdate());
        model.addAttribute("username", user.getFullname());
        model.addAttribute("user", user);
        return "hms/edit-profile";
    }

    @PostMapping("/hms/update-profile")
    public String updateProfile(@ModelAttribute("user") Users use, Model model) {
        userService.updateUser(use, user.getId());
        user = userService.getUserById(user.getId());
        return getEditProfile(model);
    }

    @GetMapping("/hms/change-password")
    public String getChangePassword(Model model) {
        model.addAttribute("username", user.getFullname());
        return "hms/change-password";
    }

    @GetMapping("/hms/forgot-password")
    public String getForgotPassword() {
        
        return "hms/forgot-password";
    }

    @GetMapping("/hms/registeration")
    public String getRegisteration(Model model) {
        Users user = new Users();
        model.addAttribute("message", "");
        model.addAttribute("user", user);
        model.addAttribute("female", "female");
        model.addAttribute("male", "male");
        return "hms/registeration";
    }

    @PostMapping("/register-user")
    public String printDetails(@ModelAttribute("user") Users user, @RequestParam("password_again") String confPassword, Model model) {
        
        if(!user.getPassword().equals(confPassword) || user.getPassword().equals("")) {
            model.addAttribute("message", "Passwords do not match");
            model.addAttribute("firstTime", false);
            return getRegisteration(model);
        }
        if(!userService.addUser(user)) {
            model.addAttribute("message", "User with this email already exists");
            model.addAttribute("firstTime", false);
            return getRegisteration(model);
        }
        
        return getPatientLoginpage();
    }

    public List<String> getDoctorSpecializationList() {
        return new ArrayList<>(Arrays.asList("Gynaecologist", "General Physician", "Dermatologist", "Homeopath", "Ayurveda", "Dentist", "ENT Specialist", "Demo Test", "Bones Specialist"));
   }

}
