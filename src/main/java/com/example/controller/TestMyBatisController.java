package com.example.controller;

import com.example.controller.base.BaseController;
import com.example.entity.Employees;
import com.example.entity.Titles;
import com.example.service.EmployeesService;
import com.example.service.TitlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by baixiangzhu on 2017/7/17.
 */
@RestController
public class TestMyBatisController extends BaseController{

    @Autowired
    private TitlesService titlesService;

    @Autowired
    private EmployeesService employeesService;

    @PutMapping("/title")
    public Object addTitle(@RequestBody Titles titles){

        int insert = titlesService.insert(titles);

        return insert;
    }

    @GetMapping("/title")
    public Object getTitle(Integer empNo){

        Titles titles = titlesService.findByEmpNo(empNo);

        return titles;
    }

    @PutMapping("/employees")
    public Object addEmployees(@RequestBody Employees employees){

        int insert = employeesService.insert(employees);

        return insert;
    }

    @GetMapping("/employees")
    public Object getEmployees(Integer empNo){

        Employees employees = employeesService.findByEmpNo(empNo);

        return employees;
    }
}
