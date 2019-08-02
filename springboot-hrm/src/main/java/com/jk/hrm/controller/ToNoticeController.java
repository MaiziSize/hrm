package com.jk.hrm.controller;

import com.jk.hrm.bean.Notice;
import com.jk.hrm.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class ToNoticeController {
    @Autowired
    private NoticeService noticeService;

    @RequestMapping("/notice/noticeList")
    public String toNoticeList(Model model){
        List<Notice> notices = noticeService.finAllNotice();
        model.addAttribute("notices",notices);
        return "/notice/noticeList";
    }


    @RequestMapping("/notice/toAddNotice")
    public String toAddNotice(){
        return "/notice/addNotice";
    }
}
