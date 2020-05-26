package com.question.common.annotation;

import java.lang.annotation.*;

/**
 * @Author: FanJiaKai
 * @Description:
 * @Date: Created in 2019/12/11 0:29
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface WebLog {

    /**
     * 日志描述信息
     */
    String value() default "";
}
