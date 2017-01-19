package com.bigdata.hbr.service.impl;

import com.bigdata.hbr.entity.User;
import com.bigdata.hbr.entity.UserExample;
import com.bigdata.hbr.exception.GenericException;
import com.bigdata.hbr.mapper.UserMapper;
import com.bigdata.hbr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by percy on 2017/1/5.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper mapper;

    @Override
    public User getByUserName(String username) throws GenericException {
        if (StringUtils.isEmpty(username)) {
            throw new GenericException("用户名为空");
        }
        return mapper.selectByPrimaryKey(username);
    }

    @Override
    public int addUser(String username,String password,String name,String gender)  {
        User user = new User();
        user.setUsername(username);
        user.setRole("common");
        user.setPassword(password);
        user.setName(name);
        user.setGender(gender);

        return mapper.insert(user);
    }

    @Override
    public int addDoctor(String username,String password,String name,String gender)  {
        User user = new User();
        user.setUsername(username);
        user.setRole("doctor");
        user.setPassword(password);
        user.setName(name);
        user.setGender(gender);

        return mapper.insert(user);
    }

    @Override
    public int deleteDoctor(String username){
        return mapper.deleteByPrimaryKey(username);
    }

    @Override
    public List<User> getDoctors(String doctorName) throws GenericException {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isEmpty(doctorName)) {
            criteria.andNameLike("%" + doctorName + "%");
        }
        criteria.andRoleEqualTo("doctor");
        return mapper.selectByExample(example);
    }

}
