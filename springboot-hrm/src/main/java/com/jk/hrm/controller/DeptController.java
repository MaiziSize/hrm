package com.jk.hrm.controller;

import com.jk.hrm.bean.Dept;
import com.jk.hrm.bean.Employee;
import com.jk.hrm.service.DeptService;
import com.jk.hrm.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class DeptController {

    @Autowired
    DeptService deptService;
    @Autowired
    EmpService empService;
    //去添加
    @RequestMapping("/dept/toAddDept")
    public String toAddDept(){
        return "/dept/addDept";
    }

    //添加
    @RequestMapping("/dept/addDept")
    public void addDept(Dept dept, HttpServletResponse response) throws IOException {
        deptService.addDept(dept);
        response.sendRedirect("/dept/deptList");
    }
    //部门查询
    @RequestMapping("/dept/deptList")
    public String deptList(Model model){
        List<Dept> depts = deptService.SelectdeptList();
        model.addAttribute("depts",depts);
        return "/dept/deptList";
    }

    //删除
    @RequestMapping("/dept/deleteDept")
    public void deleteDept(int id,HttpServletResponse response) throws IOException {
        deptService.deleteDept(id);
        response.sendRedirect("/dept/deptList");
    }
    //去修改
    @RequestMapping("/dept/toUpdateDept")
    public String toUpdateDept(Model model,int id){
        Dept dept = deptService.getDept(id);
        model.addAttribute("dept",dept);
        return "/dept/updateDept";
    }

    @RequestMapping("/dept/updateDept")
    public void updateDept(HttpServletResponse response,Dept dept) throws IOException {
        deptService.upDateDept(dept);
        response.sendRedirect("/dept/deptList");
    }


}
