package com.example.Hospital.Management.Controllers;

import com.example.Hospital.Management.models.Doctor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    HashMap<Integer, Doctor> doctorDb = new HashMap<>();

    @PostMapping("/addDoctor")
    public String addDoctor(@RequestBody Doctor doctor) {

        int doctorId = doctor.getDoctorId();
        doctorDb.put(doctorId, doctor);

        return "Doctor added successfully";
    }

}
