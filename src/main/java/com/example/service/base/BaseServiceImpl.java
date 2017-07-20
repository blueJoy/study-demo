package com.example.service.base;


import com.example.mapper.base.BaseMapper;

import java.io.Serializable;

/**
 * Created by baixiangzhu on 2017/7/19.
 */
public abstract class BaseServiceImpl implements BaseService {

    private BaseMapper mapper;

    public void setMapper(BaseMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public int insert(Object o) {
        return mapper.insert(o);
    }

    @Override
    public Object findByEmpNo(Serializable id) {
        return mapper.selectByEmpNo(id);
    }
}
