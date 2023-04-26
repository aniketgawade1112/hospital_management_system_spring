package com.example.Hospital.Management.repository;


import com.example.Hospital.Management.models.Nurse;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class NurseRepository {

    // This is class that will contain database (HashMap, MySql)

    HashMap<Integer, Nurse> nurseDB = new HashMap<>();

    public String addNurse(Nurse nurse) {

        int key = nurse.getNurseId();
        nurseDB.put(key, nurse);

        return "Nurse added successfully";

    }

    public List<Nurse> getAllNurse() {

        return nurseDB.values().stream().toList();
    }

}
