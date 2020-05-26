/*
package com.question.common.aop;

import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Map;

*/
/**
 * @Author: FanJiaKai
 * @Description: 开启分页切面
 * @Date: Created in 2019/12/13 23:08
 *//*

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
            Map<String, Object> map = (Map<String, Object>)args[0];
            PageHelper.startPage(Integer.parseInt(String.valueOf(map.get("pageNum"))),Integer.parseInt(String.valueOf(map.get("pageSize"))));
        }
    }
}
*/
