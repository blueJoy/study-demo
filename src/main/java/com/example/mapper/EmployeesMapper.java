package com.example.mapper;

import com.example.entity.Employees;
import com.example.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by baixiangzhu on 2017/7/17.
 */
@Mapper
public interface EmployeesMapper extends BaseMapper<Employees,Integer>{

}
