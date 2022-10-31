package com.HMS.HealthCare.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.HMS.HealthCare.DTO.AppointmentTable;
import com.HMS.HealthCare.DTO.DoctorDto;
import com.HMS.HealthCare.Entity.Admin;
import com.HMS.HealthCare.Entity.Appointment;
import com.HMS.HealthCare.Entity.Contact;
import com.HMS.HealthCare.Entity.Doctors;
import com.HMS.HealthCare.Entity.Patient;
import com.HMS.HealthCare.Entity.Tblmedicalhistory;
import com.HMS.HealthCare.Entity.Tblpatient;
import com.HMS.HealthCare.Repository.DoctorRepository;
import com.HMS.HealthCare.Repository.MedicalHistoryRepository;
import com.HMS.HealthCare.Service.AppointmentService;
import com.HMS.HealthCare.Service.AppointmentTableService;
import com.HMS.HealthCare.Service.DoctorDtoService;
import com.HMS.HealthCare.Service.DoctorService;
import com.HMS.HealthCare.Service.MedicalHistoryService;
import com.HMS.HealthCare.Service.PatientService;
import com.HMS.HealthCare.Service.UserService;

@Controller
//@RequestMapping("/hms/admin")
public class AdminController {

     @Autowired
     private DoctorService doctorService;
     @Autowired
     private DoctorDtoService doctorDtoService;
     @Autowired
     private UserService userService;
     @Autowired
     private PatientService patientService;
     @Autowired
     private MedicalHistoryService medHistoryService;
     @Autowired
     private AppointmentService appointmentService;
     @Autowired
     private AppointmentTableService aTableService;

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
     public String getDoctorSpecilization(Model model) {
          model.addAttribute("doctors", doctorService.getAllDoctors());
          List<String> specials = getDoctorSpecializationList();
          model.addAttribute("options", specials);
          return "hms/admin/doctor-specilization";
     }

     @GetMapping("/hms/admin/dashboard")
          public String getDashboard() {
          return "hms/admin/dashboard";
     }

     @GetMapping("/hms/admin/add-doctor")
     public String getAddDoctor(Model model) {
          DoctorDto doctorDto = new DoctorDto();
          model.addAttribute("doctor", doctorDto);
          List<String> specials = getDoctorSpecializationList();
          model.addAttribute("options", specials);
          return "hms/admin/add-doctor";
     }

     @PostMapping("/hms/admin/add-doctor")
     public String addDoctor(@ModelAttribute("doctor") DoctorDto doctorDto, @Valid String cfpass, Model model) {
          boolean error = false;
          if(!doctorDto.getPassword().equals(cfpass)) {
               error = true;
               model.addAttribute("passwordmatch", "Passwords don't match!");
          }
          if(doctorService.checkEmailAvailability(doctorDto.getEmail())) {
               error = true;
               model.addAttribute("emailavailability", "This username is already used");
          }
          if(error)
               return getAddDoctor(model);
          doctorService.saveDoctor(doctorDto);
          return getManageDoctors(model);
     }

     @GetMapping("/hms/admin/manage-doctors") 
     public String getManageDoctors(Model model) {
          model.addAttribute("doctors", doctorService.getAllDoctors());
          return "hms/admin/manage-doctors";
     }

     @GetMapping("/hms/admin/remove-doctor/{id}")
     public String removeDoctor(@PathVariable("id") Long id, Model model) {
          doctorService.removeDoctor(id);
          model.addAttribute("doctors", doctorService.getAllDoctors());
          return "hms/admin/manage-doctors";
     }

     @GetMapping("/hms/admin/manage-users")
     public String getManageUsers(Model model) {
          model.addAttribute("users",userService.getAllUsers());
          return "hms/admin/manage-users";
     }
     @GetMapping("/hms/admin/remove-users/{id}")
     public String removeUser(@PathVariable("id") Long id, Model model) {
          userService.deleteUserById(id);
          model.addAttribute("users", userService.getAllUsers());
          return "hms/admin/manage-users";
     }
    
     @GetMapping("/hms/admin/manage-patient")
     public String getManagePatient(Model model) {
          model.addAttribute("patients", patientService.getAllPatients());
          return "hms/admin/manage-patient";
     }
   
     @GetMapping("/hms/admin/view-patient/{id}")
     public String getViewPatient(@PathVariable("id") Long id, Model model) {
          Tblpatient patient = patientService.getPatientById(id);
          model.addAttribute("name", patient.getPatientname());
          model.addAttribute("email", patient.getPatientemail());
          model.addAttribute("phoneno", patient.getPatientcontno());
          model.addAttribute("address", patient.getPatientadd());
          model.addAttribute("gender", patient.getPatientgender());
          model.addAttribute("age", patient.getPatientage());
          model.addAttribute("medicalhistory", patient.getPatientmedhis());
          model.addAttribute("regdate", patient.getCreationdate());
          List<Tblmedicalhistory> li = medHistoryService.getMedicalHistoryById(id);
          model.addAttribute("historys", li);
          return "hms/admin/view-patient";
     }

     @GetMapping("/hms/admin/appointment-history")
     public String getAppointmentHistory(Model model) {
          List<AppointmentTable> ans = aTableService.getAppointmentHistoryList();
          model.addAttribute("tables", ans);
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

     @GetMapping("/hms/admin/change-password")
     public String getChangePassword() {
     return "hms/admin/change-password";
     }

     @GetMapping("/hms/admin/edit-doctor-specialization/{id}")
     public String getEditDoctorSpecialization(@PathVariable("id") Long id, Model model) {
          Doctors doctor = doctorService.getDoctorById(id);
          DoctorDto doctorDto = setPredefinedValue(doctor);
          List<String> specials = getDoctorSpecializationList();
          int ind = specials.indexOf(doctor.getSpecilization());
          if(ind != 0) {
               specials.remove(ind);
               specials.add(0, doctor.getSpecilization());
          }
          model.addAttribute("options", specials);
          model.addAttribute("doctor", doctorDto);
          return "hms/admin/edit-doctor-specialization";
     }

     @PostMapping("hms/admin/fetch-doctor-specilization")
     public String fetchDoctorSpecialization(@Valid String option, Model model) {
          System.out.println("Specialization = " + option);
          List<Doctors> li = doctorService.getDoctorBySpecialization(option);
          model.addAttribute("doctors", li);
          System.out.println(li);
          List<String> specials = getDoctorSpecializationList();
          model.addAttribute("options", specials);
          return "/hms/admin/doctor-specilization";
     }

     @PostMapping("hms/admin/edit-doctor-specialization/{id}")
     public String editDoctorSpecialization(@PathVariable("id") Long id, @ModelAttribute("doctor") DoctorDto doctor, Model model) {
          doctorService.updateDoctorById(doctor, id);
          System.out.println("apple = " + id);
          model.addAttribute("successful", "Doctor details updated successfully!");
          return getEditDoctorSpecialization(id, model);
     }

     @GetMapping("/hms/admin/edit-doctor/{id}")
     public String getEditDoctor(@PathVariable("id") Long id, Model model) {
          
          Doctors doctor = doctorService.getDoctorById(id);
          DoctorDto doctordto = setPredefinedValue(doctor);
          List<String> specials = getDoctorSpecializationList();
          int ind = specials.indexOf(doctor.getSpecilization());
          if(ind != 0) {
               specials.remove(ind);
               specials.add(0, doctor.getSpecilization());
          }
          model.addAttribute("id", id);
          model.addAttribute("doctorname", doctor.getDoctorname());
          model.addAttribute("creationdate", doctor.getCreationdate());
          model.addAttribute("updationdate", doctor.getUpdationdate());
          model.addAttribute("specilization", specials);

          model.addAttribute("doctor", doctordto);
          //System.out.println("Apple = " + doctor.getAddress());
          return "hms/admin/edit-doctor";
     }

     @PostMapping("/hms/admin/update-doctor/{id}")
     public String updateDoctor(@PathVariable("id") Long id, @ModelAttribute("doctor") DoctorDto doctor, Model model) {
          doctorService.updateDoctorById(doctor, id);          
          model.addAttribute("updationDetail", "Doctor details updated successfully!");
          return getEditDoctor(id, model);
     }

     @GetMapping("/hms/admin/query-details")
          public String getQueryDetails() {
          return "hms/admin/query-details";
     }

     public DoctorDto setPredefinedValue(Doctors doctor) {
          DoctorDto doctordto = new DoctorDto();
          doctordto.setDocname(doctor.getDoctorname());
          doctordto.setAddress(doctor.getAddress());
          doctordto.setContactno(doctor.getContactno());
          doctordto.setFees(doctor.getDocfees());
          doctordto.setEmail(doctor.getDocemail());
          doctordto.setId(doctor.getId());
          return doctordto;
     }

     public List<String> getDoctorSpecializationList() {
          return new ArrayList<>(Arrays.asList("Gynaecologist", "General Physician", "Dermatologist", "Homeopath", "Ayurveda", "Dentist", "ENT Specialist", "Demo Test", "Bones Specialist"));
     }

}
