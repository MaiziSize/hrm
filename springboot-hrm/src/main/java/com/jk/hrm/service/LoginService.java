package com.jk.hrm.service;

import com.jk.hrm.bean.User;

public interface LoginService {
    User findByNameAndPwd(String name, String password);
}
