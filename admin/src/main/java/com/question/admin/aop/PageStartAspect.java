package com.question.admin.aop;

import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Author: FanJiaKai
 * @Description: 开启分页切面
 * @Date: Created in 2019/12/13 23:08
 */

@Aspect
@Component
@Slf4j
public class PageStartAspect {

    @Pointcut("@annotation(com.question.common.annotation.PageStart)")
    public void pageStart(){}

    @Before("pageStart()")
    public void doBefor(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        if (args != null && args.length > 0){
            Class clazz = args[0].getClass();
            int pageNum = 0;
            int pageSize = 0;
            while (clazz != null){
                try {
                    for (Field field : clazz.getDeclaredFields()){
                        field.setAccessible(true);
                        if ("pageNum".equals(field.getName())){
                            pageNum = Integer.valueOf(String.valueOf(field.get(args[0])));
                        }
                        if ("pageSize".equals(field.getName())){
                            pageSize = Integer.valueOf(String.valueOf(field.get(args[0])));
                        }
                    }
                clazz = clazz.getSuperclass();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            PageHelper.startPage(pageNum,pageSize);
        }
    }
}
