package com.bigdata.hbr.service.impl;

import com.bigdata.hbr.entity.PatientResult;
import com.bigdata.hbr.entity.UserResult;
import com.bigdata.hbr.entity.UserResultExample;
import com.bigdata.hbr.mapper.PatientMapper;
import com.bigdata.hbr.mapper.PatientResultMapper;
import com.bigdata.hbr.mapper.UserResultMapper;
import com.bigdata.hbr.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Zero on 2017/1/8.
 */
@Service("resultService")
public class ResultServiceImpl implements ResultService{

    @Autowired
    private PatientResultMapper patientResultMapper;

    @Autowired
    private UserResultMapper userResultMapper;
    @Override
    public PatientResult getPatientResult(int patientid){
        return patientResultMapper.selectByPrimaryKey(patientid);
    }
    //boolean addUser(User user) throws GenericException;
    @Override
    public List<UserResult> getUserResult(String username, Long timestamp){
        UserResultExample example = new UserResultExample();
        UserResultExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        criteria.andLogTimeGreaterThan(new Date(timestamp));
        return userResultMapper.selectByExample(example);
    }

}
