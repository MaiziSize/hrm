package com.jk.hrm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class pageController {

    @RequestMapping("/{page}")
    public String page(@PathVariable String page){
        return page;
    }
}
