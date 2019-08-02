package com.jk.hrm.controller;

import com.jk.hrm.bean.User;
import com.jk.hrm.service.impl.LoginServiceImpl;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.jk.hrm.constant.WebConstant;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.sql.Date;


@Controller
public class LoginController {

    @Autowired
    private LoginServiceImpl loginServiceImpl;


    @RequestMapping("/tologin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/loginAjax")
    @ResponseBody
    public String LoginAjax(HttpServletRequest request,String name,String code,String password) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        User user = loginServiceImpl.findByNameAndPwd(name,password);
        request.getSession().setAttribute(WebConstant.SESSION_USER,user);
        System.out.println(user);
        jsonObject.put("flag","0");
        jsonObject.put("tip","登录成功");
        return jsonObject.toString();
    }

}
