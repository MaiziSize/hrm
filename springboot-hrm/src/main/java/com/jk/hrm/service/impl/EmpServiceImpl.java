package com.jk.hrm.service.impl;

import com.jk.hrm.bean.Employee;
import com.jk.hrm.bean.EmployeeInfo;
import com.jk.hrm.dao.EmployeeMapper;
import com.jk.hrm.service.EmpService;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    EmployeeMapper employeeMapper;

    @Override
    public List<Employee> selectEmpList() {
        return employeeMapper.find(null);
    }

    @Override
    public void addEmp(Employee employee) {
        employeeMapper.save(employee);
    }
    //删除
    @Override
    public void delete(int id) {
        employeeMapper.delete(id);
    }

    @Override
    public Employee getUpdateEmp(int id) {
        return employeeMapper.get(id);
    }

    @Override
    public void upDateEmp(Employee employee) {
        employeeMapper.update(employee);
    }
    //模糊查找
    @Override
    public List<Employee> selectEmp(Employee employee) {
        return employeeMapper.selectEmp(employee);
    }

    @Override
    public void empDownExcel(HttpServletResponse response, HttpServletRequest request) {
        //导出excle
        //先查询出需要导出的数据
        List<EmployeeInfo> employees = employeeMapper.findByPage(null);
        //定义表头
        String [] s = {"编号","姓名","性别","手机号码","邮箱","职位","学历","身份证号码","部门","联系地址","创建日期","日期"};
        String sheetName = "工作表单";
        //创建工作表
        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建工作表中的工作单
        HSSFSheet sheet = workbook.createSheet(sheetName);
        //创建标题行 并设置内容 设置shett的名字
        HSSFRow row = sheet.createRow(0);
        for(int i=0;i<s.length;i++){
            //设置列数
            HSSFCell cell= row.createCell(i);
            //将值设入
            cell.setCellValue(s[i]);
        }
        //把需要的值放入excel中
        for(int i = 0;i<employees.size();i++){
            //设置行数
            row = sheet.createRow(i+1);
            //获取employees中的属性
            EmployeeInfo employeeInfo = employees.get(i);
            //通过反射
            Field[] fields = employeeInfo.getClass().getDeclaredFields();
            for(int u=0;u<fields.length;u++){
                Field field = fields[u];
                //创建单元格
                HSSFCell cell = row.createCell(u);
                if(!field.isAccessible()){
                    field.setAccessible(true);
                }
                try {
                    //放入值
                    cell.setCellValue(field.get(employeeInfo).toString());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        //响应给客户
        response.setHeader("Content-Disposition","attachment;filename=employeeInfo.xls");
        try {
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
