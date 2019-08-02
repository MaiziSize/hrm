package com.jk.hrm.service.impl;

import com.jk.hrm.bean.User;
import com.jk.hrm.dao.UserMapper;
import com.jk.hrm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> selectUserList() {
        return userMapper.find(null);
    }

    @Override
    public void addUser(User user) {
        userMapper.save(user);
    }

    @Override
    public void deleteUser(int id) {
        userMapper.delete(id);
    }

    @Override
    public User getUser(int id) {
        return userMapper.get(id);
    }

    @Override
    public void upDateUser(User user) {
        userMapper.update(user);
    }

    @Override
    public void upDate(User user) {
        userMapper.checkUser(user);
    }


}
