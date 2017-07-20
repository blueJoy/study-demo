package com.example.service.impl;

import com.example.entity.Employees;
import com.example.entity.Titles;
import com.example.mapper.EmployeesMapper;
import com.example.mapper.TitlesMapper;
import com.example.service.EmployeesService;
import com.example.service.TitlesService;
import com.example.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by baixiangzhu on 2017/7/17.
 */
@Service
public class EmployeesServiceImple implements EmployeesService {

    @Autowired
    private EmployeesMapper employeesMapper;


    @Override
    public int insert(Employees employees) {
        return employeesMapper.insert(employees);
    }

    @Override
    public Employees findByEmpNo(Integer empNo) {
        return employeesMapper.selectByEmpNo(empNo);
    }

}
