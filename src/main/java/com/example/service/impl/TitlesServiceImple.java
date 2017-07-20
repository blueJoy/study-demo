package com.example.service.impl;

import com.example.entity.Titles;
import com.example.mapper.TitlesMapper;
import com.example.service.TitlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by baixiangzhu on 2017/7/17.
 */
@Service
public class TitlesServiceImple implements TitlesService {

    @Autowired
    private TitlesMapper titlesMapper;


    @Override
    public int insert(Titles titles) {
        return titlesMapper.insert(titles);
    }

    @Override
    public Titles findByEmpNo(Integer empNo) {
        return titlesMapper.selectByEmpNo(empNo);
    }
}
