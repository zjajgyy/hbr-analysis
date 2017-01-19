package com.bigdata.hbr.service;

import com.bigdata.hbr.entity.Patient;
import com.bigdata.hbr.entity.User;
import com.bigdata.hbr.exception.GenericException;

import java.util.List;

/**
 * Created by percy on 2017/1/5.
 */
public interface PatientService {

    int addPatient(String name,String gender,String position,String username);
    List<Patient> getByDoctor(String username) throws GenericException;
    List<Patient> getAll();
    int deletePatient(String name);
}
