package com.example.Hospital.Management.Controllers;

import com.example.Hospital.Management.models.Patient;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {


    HashMap<Integer, Patient> patientDB = new HashMap<>();

    @PostMapping("add")
    public String addPatient1(@RequestBody Patient patient) {

        return "Added Successfully";
    }

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


    @GetMapping("/getInfoViaPathVariable/{patientId}")
    public Patient getPatientInfo(@PathVariable("patientId") Integer patientId) {

        Patient patient = patientDB.get(patientId);
        return patient;

    }

    @GetMapping("/getPatients/{age}/{disease}")
    public List<Patient> getPatients(@PathVariable("age") Integer age, @PathVariable("disease") String disease) {

        List<Patient> patients = new ArrayList<>();

        for(Patient p : patientDB.values()) {

            if (p.getAge() > age && p.getDisease().equals(disease)) {
                patients.add(p);
            }
        }

        return patients;
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

    @PutMapping("/updateDisease")
    public String updateDisease(@RequestParam("patientId") Integer patientId, @RequestParam("disease") String disease) {

        if (patientDB.containsKey(patientId)) {

            Patient patient = patientDB.get(patientId);

            patient.setDisease(disease);

            patientDB.put(patientId, patient);

            return "Updated Successfully";
        }
        else {

            return "Patient dose not exist";
        }

    }

    @PutMapping("/updatePatientsDetails")
    public String updatePatientDetails(@RequestBody Patient patient) {

        int key = patient.getPatientId();

        if (patientDB.containsKey(key)) {
            patientDB.put(key, patient);
            return "Updated Patient Successfully";
        }
        else {
            return "Data is not existing";
        }
    }

    @DeleteMapping("/deletePatient")
    public String deletePatient(@RequestParam("patientId") Integer patientId) {

        patientDB.remove(patientId);

        return "Patient Deleted Successfully";
    }
}
