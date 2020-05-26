package com.question.common.utils;

import com.google.common.base.Strings;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: FanJiaKai
 * @Description: 线程中存储用户信息
 * @Date: Created in 2019/12/11 1:09
 */
public class SmartContext {
    private static ThreadLocal<Map<String,Object>> mapThreadLocal = new ThreadLocal() {
        @Override
        protected Map<String,Object> initialValue() {
            return new HashMap<>();
        }
    };


    private static final String USER_ID = "userId";

    public static boolean containsKey(String key){
        return mapThreadLocal.get().containsKey(key);
    }

    public static String getUserId(){
        if (!containsKey(USER_ID)){
            throw new RuntimeException("not exists user id!");
        }
        return String.valueOf(mapThreadLocal.get().get(USER_ID));
    }

    public static void putUserId(String userId){
        if (!Strings.isNullOrEmpty(userId)){
            mapThreadLocal.get().put(USER_ID,userId);
        }
    }

}
