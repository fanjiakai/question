package com.question.admin.annotation;

import java.lang.annotation.*;

/**
 * @Author: FanJiaKai
 * @Description:
 * @Date: Created in 2019/12/13 18:49
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSourceInterceptor {

    /**
     * 需要过滤的数据方法
     */
    String methodName() default "";
}
