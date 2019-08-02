package com.jk.hrm.service.impl;

import com.jk.hrm.bean.User;
import com.jk.hrm.dao.UserMapper;
import com.jk.hrm.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService  {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByNameAndPwd(String name, String password) {
        return userMapper.findByNameAndPwd(name,password);
    }
}
