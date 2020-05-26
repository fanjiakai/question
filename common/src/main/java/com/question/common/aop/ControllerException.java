package com.question.common.aop;

import com.question.common.enumeration.MessageEnum;
import com.question.common.response.ResponseJson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: FanJiaKai
 * @Description: 前端控制器异常捕获
 * @Date: Created in 2019/12/13 22:45
 */
@ControllerAdvice
@Slf4j
public class ControllerException {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseJson nullPointerExceptionHandler(Exception e){
        log.error("ExceptionHandler: ", e);
        return ResponseJson.createOperationError(e.getMessage());
    }
}
