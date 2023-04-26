package com.example.Hospital.Management.service;

import com.example.Hospital.Management.models.Nurse;
import com.example.Hospital.Management.repository.NurseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NurseService {

    int age;

    public NurseService() {}

    public NurseService(int age) {
        this.age = age;
    }

    @Autowired
    NurseRepository nurseRepository;

    public String addNurse(Nurse nurse) {

        // We should write some logic:
        // Validations

        if (nurse.getNurseId() < 0) {

            return "Enter a valid nurseId";
        }

        if (nurse.getName().equals(null)) {

            return "Name should not be null";
        }

        // solving it to the database
        String ans = nurseRepository.addNurse(nurse);

        return ans;
    }

    public List<Nurse> getList(int age) {

        // calling all the nurses from database

        List<Nurse> nurses = nurseRepository.getAllNurse();

        // Now I am writing the logic to extract required

        List<Nurse> finalList = new ArrayList<>();

        for(Nurse nurse : nurses) {
            if (nurse.getAge() > age) {
                finalList.add(nurse);
            }
        }
        return finalList;
    }

    public List<Nurse> getNursesByQualification(String qualification) {

        List<Nurse> nurseList = nurseRepository.getAllNurse();

        // Now I am writing the logic to filter base on qualification

        List<Nurse> nurses = new ArrayList<>();

        for(Nurse nurse : nurseList) {
            if (nurse.getQualification().equals(qualification)) {
                nurses.add(nurse);
            }
        }
        return nurses;
    }
}
