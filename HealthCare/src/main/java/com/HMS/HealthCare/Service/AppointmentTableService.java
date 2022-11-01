package com.HMS.HealthCare.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HMS.HealthCare.DTO.AppointmentTable;
import com.HMS.HealthCare.Entity.Appointment;
import com.HMS.HealthCare.Entity.Doctors;
import com.HMS.HealthCare.Entity.Tblpatient;
import com.HMS.HealthCare.Entity.Users;
import com.HMS.HealthCare.Repository.AppointmentRepository;

@Service
public class AppointmentTableService {
    
    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private UserService userService;

    public List<AppointmentTable> getAppointmentHistoryList() {
        List<Appointment> li = appointmentService.getAllAppointments();
          List<AppointmentTable> ans = new ArrayList<>();
          
            Long count = 1l;
            for(Appointment app : li) {
                Doctors doctor = doctorService.getDoctorById(Long.valueOf(app.getDoctorid()));
                Users patient = userService.getUserById(Long.valueOf(app.getUserid()));
                if(doctor == null || patient == null)
                    continue;
                String currentStatus = ((app.getDoctorstatus().equals("1")) ? "Active" : "Cancelled by Doctor");
                String action = ((app.getDoctorstatus().equals("1")) ? "No action Yet" : "Cancelled");
                AppointmentTable table = new AppointmentTable(count++, doctor.getDoctorname(), patient.getFullname(),
                                                        doctor.getSpecilization(), String.valueOf(doctor.getDocfees()), app.getAppointmentdate() + " " + app.getAppointmenttime(),
                                                        app.getPostingdate(), currentStatus, action);
                ans.add(table);

            }
            return ans;
    }

}
