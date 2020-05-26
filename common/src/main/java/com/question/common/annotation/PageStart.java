package com.question.common.annotation;

import java.lang.annotation.*;

/**
 * @Author: FanJiaKai
 * @Description:
 * @Date: Created in 2019/12/13 23:00
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface PageStart {

    /**
     * 开启分页 方法名
     */
    Class clazz();
}
