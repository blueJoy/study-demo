package com.example.controller.base;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by baixiangzhu on 2017/7/19.
 */
public class BaseController {

    private static final String YYYYMMDD = "yyyy-MM-dd";

    private String dateFormat;


    /**
     * 把前端传过来的string类型的日期，转换为date
     * @param request
     * @param binder
     */
    @InitBinder
    protected void initBinder(HttpServletRequest request,ServletRequestDataBinder binder){

        binder.registerCustomEditor(Date.class,
                new CustomDateEditor(new SimpleDateFormat(StringUtils.isEmpty(dateFormat) ? YYYYMMDD : dateFormat),
                        false));
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }



}
