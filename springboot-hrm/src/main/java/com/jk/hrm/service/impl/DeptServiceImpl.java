package com.jk.hrm.service.impl;

import com.jk.hrm.bean.Dept;
import com.jk.hrm.bean.Employee;
import com.jk.hrm.dao.DeptMapper;
import com.jk.hrm.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    DeptMapper deptMapper;
    //查询所有
    @Override
    public List<Dept> SelectdeptList() {
        return deptMapper.find(null);
    }
    //添加部门
    @Override
    public void addDept(Dept dept) {
        deptMapper.save(dept);
    }

    @Override
    public void deleteDept(int id) {
        deptMapper.delete(id);
    }

    @Override
    public Dept getDept(int id) {
        return deptMapper.get(id);
    }

    @Override
    public void upDateDept(Dept dept) {
        deptMapper.update(dept);
    }

    @Override
    public List<Dept> getDepts() {
        return deptMapper.findByPage(null);
    }

}
