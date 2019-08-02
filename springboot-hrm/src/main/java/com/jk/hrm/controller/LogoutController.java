package com.jk.hrm.controller;

import com.jk.hrm.bean.User;
import com.jk.hrm.constant.WebConstant;
import com.jk.hrm.service.impl.LoginServiceImpl;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller
public class LogoutController {


    @RequestMapping("/logout")
    @ResponseBody
    public void LoginAjax(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().invalidate();
        response.sendRedirect("/tologin");
    }

}
