package com.jk.hrm.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.jk.hrm.bean.Notice;
import com.jk.hrm.bean.User;
import com.jk.hrm.constant.WebConstant;
import com.jk.hrm.service.NoticeService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    //添加
    @RequestMapping("/notice/addNotice")
    public void addNotice(Notice notice,HttpServletRequest request,HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute(WebConstant.SESSION_USER);
        notice.setUser(user);
        notice.setCreateDate(new Date());
        noticeService.saveNotice(notice);
        response.sendRedirect("/notice/noticeList");
    }


    @RequestMapping("/notice/uploadPic")
    @ResponseBody
    public String uploadPic(MultipartFile file, HttpServletResponse response, HttpServletRequest request) throws IOException {
        String realPath = request.getServletContext().getRealPath("/images/notice/");
        String newFileName = UUID.randomUUID().toString() + file.getOriginalFilename();
        file.transferTo(new File(realPath+newFileName));
        return "/images/notice/"+newFileName;
    }
    //去修改
    @RequestMapping("/notice/toUpdateNotice")
    public String toUpadteNotice(int id, Model model){
        Notice notice = noticeService.getById(id);
        model.addAttribute("notice",notice);
        return "/notice/updateNotice";
    }
    //修改
    @RequestMapping("/notice/updateNotice")
    public void updateNotice(Notice notice,HttpServletResponse response) throws IOException {
        noticeService.updateNotice(notice);
        response.sendRedirect("/notice/noticeList");
    }

    //删除
    @RequestMapping("/notice/deleteNotice")
    public void deleteNotice(int id,HttpServletResponse response) throws IOException {
        noticeService.deleteNotice(id);
        response.sendRedirect("/notice/noticeList");
    }
    //页面详情
    @RequestMapping("/notice/prevNotice")
    public String prevNotice(Model model,int id){
        Notice notice = noticeService.getId(id);
        model.addAttribute("notice",notice);
        return "/notice/prevNotice";
    }

    //模糊搜索
    @RequestMapping("/notice/selectNotice")
    public String selectNotice(Model model,Notice notice){
       List<Notice> notices =  noticeService.selectNotice(notice);
        model.addAttribute("notices",notices);
        return "/notice/noticeList";
    }

}
