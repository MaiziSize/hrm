package com.jk.hrm.service;

import com.jk.hrm.bean.User;

import java.util.List;

public interface UserService {
    List<User> selectUserList();

    void addUser(User user);

    void deleteUser(int id);

    User getUser(int id);

    void upDateUser(User user);

    void upDate(User user);
}
