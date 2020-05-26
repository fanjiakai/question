package com.question.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.question.common.enumeration.MessageEnum;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

/**
 * @Author: FanJiaKai
 * @Description: 返回参数
 * @Date: Created in 2019/12/11 0:29
 */
@Data
public class ResponseJson {
    public static ResponseJson newResponseJson(Object data) {
        return new ResponseJson(data);
    }

    public static ResponseJson newErrorJson(MessageEnum messageEnum) {
        return new ResponseJson("error", messageEnum.getCode(), messageEnum.getMessage());
    }

    public static ResponseJson newDataJson(MessageEnum messageEnum, Object data) {
        return new ResponseJson(data, messageEnum.getCode(), messageEnum.getMessage());
    }

    public static ResponseJson createOperationError(String message) {
        return new ResponseJson("error", HttpStatus.INTERNAL_SERVER_ERROR.value(), message);
    }

    public static ResponseJson newResponseJson() {
        return new ResponseJson("ok");
    }

    public static ResponseJson createBadRequestError(Object data) {
        ResponseJson responseJson = new ResponseJson();
        responseJson.setReturnCode(HttpStatus.BAD_REQUEST.value());
        responseJson.setReturnMsg("参数错误");
        responseJson.setData(data);
        return responseJson;
    }

    public static ResponseJson createInternalServerError() {
        ResponseJson responseJson = new ResponseJson();
        responseJson.setReturnCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        responseJson.setReturnMsg("服务器内部错误");
        return responseJson;
    }

    private static ObjectMapper objectMapper = new ObjectMapper()
            .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            .setSerializationInclusion(JsonInclude.Include.NON_NULL)       // 属性为空（“”）或者为 NULL 都不序列化
            .setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"))
            .setTimeZone(TimeZone.getTimeZone("GMT+8"));

    private Object data;

    private int returnCode = 0;

    private String returnMsg = "success";

    private ResponseJson(Object data) {
        this.data = data;
    }

    public ResponseJson(Object data, int returnCode, String returnMsg) {
        this.data = data;
        this.returnCode = returnCode;
        this.returnMsg = returnMsg;
    }

    public ResponseJson() {
    }


    public Object getData() {
        return data;
    }

    /**
     * 解决类型转换的问题
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T getData(Class<T> clazz) {
        if (data == null) {
            return null;
        }
        return objectMapper.convertValue(data, clazz);
    }

    public <T> List<T> getListData(Class<T> clazz) {
        ArrayList data = getData(ArrayList.class);
        if (data == null) {
            return null;
        }
        List<T> result = Lists.newArrayList();
        for (int i = 0; i < data.size(); i++) {
            result.add(objectMapper.convertValue(data.get(i), clazz));
        }
        return result;
    }


}
