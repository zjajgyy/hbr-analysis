package com.bigdata.hbr.service;

import com.bigdata.hbr.entity.User;
import com.bigdata.hbr.exception.GenericException;

import java.util.List;

/**
 * Created by percy on 2017/1/5.
 */
public interface UserService {

    User getByUserName(String username) throws GenericException;

    //boolean addUser(User user) throws GenericException;

    int addUser(String username,String password,String name,String gender);

    int addDoctor(String username,String password,String name,String gender);

    int deleteDoctor(String username);

    List<User> getDoctors(String doctorName) throws GenericException;
}
