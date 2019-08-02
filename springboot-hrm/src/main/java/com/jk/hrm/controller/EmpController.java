package com.jk.hrm.controller;

import com.jk.hrm.bean.Dept;
import com.jk.hrm.bean.Employee;
import com.jk.hrm.service.DeptService;
import com.jk.hrm.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Controller
public class EmpController {
    @Autowired
    EmpService empService;
    @Autowired
    DeptService deptService;
    //去添加
    @RequestMapping("/emp/toAddEmp")
    public String toAddEmp(Model model){
        List<Dept> depts = deptService.getDepts();
        model.addAttribute("depts",depts);
        return "/emp/addEmp";
    }
    //添加
    @RequestMapping("/employee/addEmp")
    public void addEmp(Employee employee,HttpServletResponse response) throws IOException {
        empService.addEmp(employee);
        response.sendRedirect("/emp/empList");
    }

    //去查询
    @RequestMapping("/emp/empList")
    public String empList(Model model){
        List<Employee> employees = empService.selectEmpList();
        List<Dept> depts = deptService.SelectdeptList();
        model.addAttribute("employees",employees);
        model.addAttribute("depts",depts);
        return "/emp/empList";
    }

    //删除
    @RequestMapping("/emp/deleteEmp")
    public void deleteEmp(int id, HttpServletResponse response) throws IOException {
        empService.delete(id);
        response.sendRedirect("/emp/empList");
    }

    //去修改
    @RequestMapping("/emp/toUpdateEmp")
    public String toUpdateEmp(Model model,int id) {
        Employee emp = empService.getUpdateEmp(id);
        List<Dept> depts = deptService.SelectdeptList();
        model.addAttribute("emp",emp);
        model.addAttribute("depts",depts);

        return "/emp/updateEmp";
    }
    //修改
    @RequestMapping("/emp/updateEmp")
    public void updateEmp(HttpServletResponse response,Employee employee) throws IOException {
        empService.upDateEmp(employee);
        response.sendRedirect("/emp/empList");
    }

    //导出excel
    @RequestMapping("/employee/downExcel")
    public void downExcel(HttpServletResponse response, HttpServletRequest request){
        empService.empDownExcel(response,request);
    }
    //查询
    @RequestMapping("/employee/selectEmployee")
    public String selectEmployee(Employee employee,Model model){
        List<Employee> employees = empService.selectEmp(employee);
        List<Dept> depts = deptService.SelectdeptList();
        model.addAttribute("employees",employees);
        model.addAttribute("depts",depts);
        return "/emp/empList";
    }

}
