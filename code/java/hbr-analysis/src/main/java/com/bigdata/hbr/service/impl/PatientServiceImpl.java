package com.bigdata.hbr.service.impl;


import com.bigdata.hbr.entity.Patient;
import com.bigdata.hbr.entity.PatientExample;
import com.bigdata.hbr.exception.GenericException;
import com.bigdata.hbr.mapper.PatientMapper;
import com.bigdata.hbr.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zero on 2017/1/8.
 */
@Service("patientService")
public class PatientServiceImpl implements PatientService{
    @Autowired
    private PatientMapper mapper;

    @Override
    public int addPatient(String name,String gender,String position,String username){
        Patient patient = new Patient();
        patient.setName(name);
        patient.setDoctorLoginName(username);
        patient.setGender(gender);
        patient.setPosition(position);
        patient.setTreatStatus("treating");

        return mapper.insert(patient);
    }

    @Override
    public List<Patient> getByDoctor(String username) throws GenericException{
        if(StringUtils.isEmpty(username)){
            throw new GenericException("用户名为空");
        }
        return mapper.selectByName(username);
    }
    @Override
    public List<Patient> getAll(){
        return mapper.selectAll();
    }

    @Override
    public int deletePatient(String name){
        return mapper.deleteByName(name);
    }


}
