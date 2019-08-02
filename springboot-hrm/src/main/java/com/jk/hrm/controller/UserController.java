package com.jk.hrm.controller;

import com.jk.hrm.bean.User;
import com.jk.hrm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("/user/userList")
    //去查询
    public String userList(Model model){
        List<User> users = userService.selectUserList();
        model.addAttribute("users",users);
        return "/user/userList";
    }
    //去添加
    @RequestMapping("/user/toAddUser")
    public String toAddUser(){
        return "/user/addUser";
    }
    //添加
    @RequestMapping("/user/addUser")
    public void addUser(HttpServletResponse response,User user) throws IOException {
        userService.addUser(user);
        response.sendRedirect("/user/userList");
    }

    @RequestMapping("/user/deleteUser")
    public void deleteUser(int id ,HttpServletResponse response) throws IOException {
        userService.deleteUser(id);
        response.sendRedirect("/user/userList");
    }

    @RequestMapping("/user/toUpdateUser")
    public String toUpdateUser(Model model,int id){
        User user = userService.getUser(id);
        model.addAttribute("user",user);
        return "/user/updateUser";
    }

    @RequestMapping("/user/updateUser")
    public void updateUser(User user, HttpServletResponse response) throws IOException {
        userService.upDateUser(user);
        response.sendRedirect("/user/userList");
    }
    @RequestMapping("/user/checkUser")
    public void checkUser (HttpServletResponse response,User user) throws IOException {
        userService.upDate(user);
        response.sendRedirect("/user/userList");
    }
}
