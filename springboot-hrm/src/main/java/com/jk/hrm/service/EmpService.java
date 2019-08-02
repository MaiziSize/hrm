package com.jk.hrm.service;

import com.jk.hrm.bean.Employee;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface EmpService {
    List<Employee> selectEmpList();

    void addEmp(Employee employee);

    void delete(int id);

    Employee getUpdateEmp(int id);

    void upDateEmp(Employee employee);

    void empDownExcel(HttpServletResponse response, HttpServletRequest request);

    List<Employee> selectEmp(Employee employee);
}
