package com.jk.hrm.controller;

import com.jk.hrm.bean.Job;
import com.jk.hrm.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class JobController {
    @Autowired
    JobService jobService;
    //去添加职业
    @RequestMapping("/job/toAddJob")
    public String toAddJob(){
        return "/job/addJob";
    }
    //添加职业
    @RequestMapping("/job/addJob")
    public void addJob(Job job, HttpServletResponse response) throws IOException {
        jobService.addJob(job);
        response.sendRedirect("/job/jobList");
    }
    //去查询
    @RequestMapping("/job/jobList")
    public String jobList(Model model){
       List<Job> job = jobService.selectJobList();
        model.addAttribute("jobs",job);
       return "/job/jobList";
    }
    //删除
    @RequestMapping("/job/deleteJob")
    public void deleteJob(int id,HttpServletResponse response) throws IOException {
        jobService.deleteJob(id);
        response.sendRedirect("/job/jobList");
    }
    //去修改
    @RequestMapping("/job/toUpdateJob")
    public String toUpdateJob(Model model,int id){
        Job job = jobService.get(id);
        model.addAttribute("job",job);
        return "/job/updateJob";
    }
    //修改
    @RequestMapping("/job/updateJob")
    public void updateJob(HttpServletResponse response,Job job) throws IOException {
         jobService.upDateJob(job);
         response.sendRedirect("/job/jobList");
    }

    @RequestMapping("/job/loadJobAjax")
    @ResponseBody
    public String loadJobAjax(){
        return jobService.loadJobAjax();
    }

}
