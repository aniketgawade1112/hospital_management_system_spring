package com.example.Hospital.Management;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class PatientController {


    HashMap<Integer, Patient> patientDB = new HashMap<>();

    @PostMapping("/addPatientViaParameters")
    public String addPatient(@RequestParam("patientId")Integer patientId, @RequestParam("name") String name,
                             @RequestParam("age") Integer age, @RequestParam("disease") String disease) {


        Patient patient = new Patient(patientId, name, disease, age);
        patientDB.put(patientId, patient);

        return "Patient added successfully";

    }

    @PostMapping("/addPatientViaRequestBody")
    public String addPatient(@RequestBody Patient patient) {

        int key = patient.getPatientId();

        patientDB.put(key, patient);

        return "Patient added via Request Body";
    }

    @GetMapping("/getPatientInfo")
    public Patient getPatient(@RequestParam("patientId") Integer patientId) {

        Patient patient = patientDB.get(patientId);

        return patient;

    }

    @GetMapping("/getAllPatients")
    public List<Patient> getAllPatients() {


        List<Patient> patients = new ArrayList<>();

        for(Patient p : patientDB.values()) {
            patients.add(p);
        }

        return patients;
    }

    @GetMapping("/getPatientByName")
    public Patient getPatientByName(@RequestParam("name") String name) {

        for(Patient p : patientDB.values()) {

            if(p.getName().equals(name)) {
                return p;
            }
        }

        return null;
    }

    @GetMapping("/getPatientsListGreaterThanAge")
    public List<Patient> getPatientsListGreaterThanAge(@RequestParam("age") Integer age) {

        List<Patient> patients = new ArrayList<>();

        for(Patient p : patientDB.values()) {

            if(p.getAge() > age) {
                patients.add(p);
            }
        }

        return patients;

    }
}
