package com.jk.hrm.service;

import com.jk.hrm.bean.Dept;
import com.jk.hrm.bean.Employee;

import java.util.List;

public interface DeptService {
    List<Dept> SelectdeptList();

    void addDept(Dept dept);

    void deleteDept(int id);

    Dept getDept(int id);

    void upDateDept(Dept dept);

    List<Dept> getDepts();

}
