package com.bigdata.hbr.service;

import com.bigdata.hbr.entity.Patient;
import com.bigdata.hbr.entity.PatientResult;
import com.bigdata.hbr.entity.User;
import com.bigdata.hbr.entity.UserResult;
import com.bigdata.hbr.exception.GenericException;

import java.util.List;

/**
 * Created by percy on 2017/1/5.
 */
public interface ResultService {

    PatientResult getPatientResult(int patientid);
    //boolean addUser(User user) throws GenericException;

    List<UserResult> getUserResult(String username, Long timestamp);


}
