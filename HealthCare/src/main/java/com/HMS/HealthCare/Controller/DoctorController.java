package com.HMS.HealthCare.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.HMS.HealthCare.DTO.AppointmentTable;
import com.HMS.HealthCare.DTO.DoctorDto;
import com.HMS.HealthCare.DTO.PatientDto;
import com.HMS.HealthCare.Entity.Doctor;
import com.HMS.HealthCare.Entity.Doctors;
import com.HMS.HealthCare.Entity.Tblmedicalhistory;
import com.HMS.HealthCare.Entity.Tblpatient;
import com.HMS.HealthCare.Repository.MedicalHistoryRepository;
import com.HMS.HealthCare.Service.AppointmentTableService;
import com.HMS.HealthCare.Service.DoctorService;
import com.HMS.HealthCare.Service.DoctorslogService;
import com.HMS.HealthCare.Service.MedicalHistoryService;
import com.HMS.HealthCare.Service.PatientDtoService;
import com.HMS.HealthCare.Service.PatientService;

@Controller
@RequestMapping("")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;
    @Autowired
    private DoctorslogService doctorslogService;
    @Autowired
    private AppointmentTableService appointmentTableService;
    @Autowired
    private PatientDtoService patientDtoService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private MedicalHistoryService medicalHistoryService;

    static Doctors doctor;
    static String doctorname;
    static Long patientid;
    
    @GetMapping("/hms/doctor")
    public String getDoctorLoginPage(Model model) {
        model.addAttribute("isNotValid", false);
        return "hms/doctor/index";
    }


    @PostMapping("/login-doctor")
    public String getDoctorDashboard(@RequestParam("username") String username,
                                     @RequestParam("password") String password, Model model) {
                    
        System.out.println("Username = " + username + " Password = " + password);
        doctor = doctorService.getDoctorByUsernameAndPassword(username.trim(), password.trim());
        if(doctor == null) {
            model.addAttribute("isNotValid", true);
            return "hms/doctor/index";
        }
        doctorname = doctor.getDoctorname();
        model.addAttribute("username", doctorname);

        return "hms/doctor/dashboard";
    }

    @GetMapping("/hms/doctor/dashboard") 
    public String getDashboard(Model model) {
        model.addAttribute("username", doctorname);
        return "hms/doctor/dashboard";
    }

    @GetMapping("/hms/doctor/forgot-password")
    public String getForgotPassword() {
        return "hms/doctor/forgot-password";
    }

    @GetMapping("/hms/doctor/appointment-history")
    public String getAppointmentHistory(Model model) {
        model.addAttribute("username", doctorname);
        List<AppointmentTable> ans = appointmentTableService.getAppointmentHistoryList();
        model.addAttribute("appointment", ans);
        return "hms/doctor/appointment-history";
    }

    @GetMapping("/hms/doctor/add-patient")
    public String getAddPatient(Model model) {
        PatientDto patient = new PatientDto();
        model.addAttribute("patient", patient);
        model.addAttribute("failmessage", "");
        model.addAttribute("successmessage", "");
        model.addAttribute("username", doctorname);
        return "hms/doctor/add-patient";
    }

    @PostMapping("hms/doctor/new-patient")
    public String addNewPatient(@ModelAttribute("patient") PatientDto patientDto, Model model) {
        boolean isSaved = patientDtoService.addPatient(patientDto, doctor.getId());
        if(isSaved) {
            model.addAttribute("failmessage", "");
            model.addAttribute("successmessage", "Patient added successfully");
        }
        else {
            model.addAttribute("failmessage", "Username already exists");
            model.addAttribute("successmessage", "");
        }
        PatientDto patient = new PatientDto();
        model.addAttribute("patient", patient);
        model.addAttribute("username", doctorname);
        return "hms/doctor/add-patient";
    }

    @GetMapping("/hms/doctor/manage-patient")
    public String getManagePatient(Model model) {
        List<Tblpatient> li = patientService.getAllPatients();
        for(int i=0; i<li.size(); ) {
            if(li.get(i).getDocid() != doctor.getId())
                li.remove(i);
            else {
                i++;
            }
        }
        model.addAttribute("patients", li);
        model.addAttribute("username", doctorname);
        return "hms/doctor/manage-patient";
    }

    @GetMapping("/hms/doctor/search")
    public String getSearch(Model model) {
        model.addAttribute("username", doctorname);
        return "hms/doctor/search";
    }

    @PostMapping("/hms/doctor/search-patient")
    public String searchPatient(@RequestParam("searchdata") String search, Model model) {
        List<Tblpatient> li = patientService.getPatientBynameOrNumber(search);
          model.addAttribute("keyword", search);
          model.addAttribute("showtable", false);
          model.addAttribute("message", "");
          if(li.size() != 0) {
               model.addAttribute("patients", li);
               model.addAttribute("showtable", true);
          } else {
               model.addAttribute("message", "No record found");
          }
          return "hms/doctor/search";

    }

    @GetMapping("/hms/doctor/edit-profile")
    public String getEditProfile(Model model) {
        model.addAttribute("username", doctorname);
        model.addAttribute("doctorname", doctorname);
        model.addAttribute("regdate", doctor.getCreationdate());
        model.addAttribute("updationdate", doctor.getUpdationdate());
        DoctorDto doctordto = setPredefinedValue(doctor);
        List<String> specials = getDoctorSpecializationList();
        int ind = specials.indexOf(doctor.getSpecilization());
        if(ind != 0) {
            specials.remove(ind);
            specials.add(0, doctor.getSpecilization());
        }
        model.addAttribute("options", specials);
        model.addAttribute("doctor", doctordto);
        return "hms/doctor/edit-profile";
    }

    @PostMapping("/hms/doctor/update-profile")
    public String updateDoctor(@ModelAttribute("doctor") DoctorDto doctordto, Model model) {
        doctorService.updateDoctorById(doctordto, doctor.getId());
        model.addAttribute("updationDetail", "Doctor details updated successfully!");
        doctorname = doctordto.getDocname();
        doctor = doctorService.getDoctorByUsernameAndPassword(doctordto.getEmail(), doctor.getPassword());
        doctorname = doctordto.getDocname();
        return getEditProfile(model);
    }

    @GetMapping("/hms/doctor/change-password")
    public String getChangePassword(Model model) {
        model.addAttribute("username", doctorname);
        return "hms/doctor/change-password";
    }

    @GetMapping("/hms/doctor/view-patient/{id}")
    public String getViewPatient(@PathVariable("id") Long id, Model model) {
        Tblpatient patient = patientService.getPatientById(id);
        List<Tblmedicalhistory> li = medicalHistoryService.getMedicalHistoryById(id);
        model.addAttribute("name", patient.getPatientname());
        model.addAttribute("email", patient.getPatientemail());
        model.addAttribute("contactno", patient.getPatientcontno());
        model.addAttribute("gender", patient.getPatientgender());
        model.addAttribute("address", patient.getPatientadd());
        model.addAttribute("age", patient.getPatientage());
        model.addAttribute("history", patient.getPatientmedhis());
        model.addAttribute("regdate", patient.getCreationdate());
        model.addAttribute("username", doctorname);
        model.addAttribute("history", li);
        patientid = id;
        return "hms/doctor/view-patient";
    }

    @PostMapping("/hms/doctor/add-medical-history")
    public String addMedicalHistory(@Valid String bp, @Valid String bs, 
                                    @Valid String weight, Model model,
                                    @Valid String temp, @Valid String pres) {
            System.out.println("Details are = " + bp + " " + bs + " " + weight + " " + temp + " " + pres);
            medicalHistoryService.saveHistory(patientid, bp, bs, weight, temp, pres);
            return getViewPatient(patientid, model);                     
    }

    @GetMapping("/hms/doctor/edit-patient/{id}")
    public String getEditPatient(@PathVariable("id") Long id, Model model) {
        PatientDto patient = new PatientDto();
        Tblpatient pat = patientService.getPatientById(id);
        patient.setAddress(pat.getPatientadd());
        patient.setAge(pat.getPatientage());
        patient.setContno(pat.getPatientcontno());
        patient.setName(pat.getPatientname());
        patient.setEmail(pat.getPatientemail());
        patient.setMedhistory(pat.getPatientmedhis());
        String date = patientService.getPatientById(id).getCreationdate();
        model.addAttribute("ids", id);
        model.addAttribute("creationdate", date);
        model.addAttribute("patient", patient);
        model.addAttribute("username", doctorname);
        return "hms/doctor/edit-patient";
    }

    @PostMapping("/hms/doctor/update-patient/{id}")
    public String updatePatient(@ModelAttribute("patient") PatientDto patient, @PathVariable("id") Long id, Model model) {
        patientDtoService.updatePatient(patient, id, doctor.getId());
        model.addAttribute("successMessage","Patient details updated Sucessfully!");
        return getEditPatient(patient.getId(), model);
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
