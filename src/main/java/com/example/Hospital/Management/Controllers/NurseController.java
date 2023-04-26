package com.example.Hospital.Management.Controllers;


import com.example.Hospital.Management.models.Nurse;
import com.example.Hospital.Management.service.NurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nurse")
public class NurseController {

    @Autowired
    NurseService nurseService;

    @GetMapping("/checkObject")
    public String checkObject() {

        System.out.println("The nurse object in nurseController " + nurseService);

        return null;
    }

    @PostMapping("/add")
    public String addNurse(@RequestBody Nurse nurse) {

        String ans = nurseService.addNurse(nurse);

        return ans;

    }

    @GetMapping("/getByAge")
    public List<Nurse> getNursesGreaterThanAge(@RequestParam("age") Integer age) {

        List<Nurse> nurseList = nurseService.getList(age);

        return nurseList;
    }

    @GetMapping("/getByQualification")
    public List<Nurse> getNursesByQualification(@RequestParam("qualification") String qualification) {

        List<Nurse> nurseList = nurseService.getNursesByQualification(qualification);

        return nurseList;

    }

}
