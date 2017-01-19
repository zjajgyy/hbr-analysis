package com.bigdata.hbr.controller;

import com.bigdata.hbr.entity.Patient;
import com.bigdata.hbr.exception.GenericException;
import com.bigdata.hbr.service.PatientService;
import com.bigdata.hbr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Zero on 2017/1/8.
 */
@RestController
@RequestMapping(value = "/patient", produces = "application/json; charset=utf-8")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public int addPatient(String name,String gender,String position,String username) {

        return patientService.addPatient(name, gender, position ,username);

    }

    @RequestMapping(value = "/getlistbydoctor", method = RequestMethod.POST)
    public List<Patient> selectPatient(String doctorUsername) {
        try {
            return patientService.getByDoctor(doctorUsername);
        } catch (GenericException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public Object selectALL() {

        Map<String, Object> res = new HashMap<>();
        res.put("data", patientService.getAll());
        res.put("code", 200);
        return res;
    }

    @RequestMapping(value = "/deletepatient", method = RequestMethod.DELETE)
    public int deletePatient(String name){
        return patientService.deletePatient(name);
    }


}
