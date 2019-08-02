package com.jk.hrm.dao;

import com.jk.hrm.base.BaseMapper;
import com.jk.hrm.bean.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * EmployeeMapper 数据访问类
 * @author qxy
 * @email 1766181826@qq.com
 * @date 2019-07-29 13:40:41
 * @version 1.0
 */
@Mapper
public interface EmployeeMapper extends BaseMapper {
    List<Employee> selectEmp(Employee employee);
}