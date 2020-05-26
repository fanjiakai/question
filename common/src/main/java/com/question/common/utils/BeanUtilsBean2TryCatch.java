package com.question.common.utils;

import org.apache.commons.beanutils.BeanUtilsBean2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunmeilin on 2019/6/20.
 */
public class BeanUtilsBean2TryCatch<V,T> {

    public static <T> T copyProperties(Object orig, Class<T> clazz){
        try {
            T dest = clazz.newInstance();
            BeanUtilsBean2.getInstance().copyProperties(dest, orig);
            return dest;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public <T> List<T> copyPropertiesList(List<V> list, Class<T> clazz){
        List<T> properties = new ArrayList<>();
        try {
            list.forEach(value -> {
//                Object t = copyProperties(value,clazz);
                properties.add(copyProperties(value,clazz));
            });
            return properties;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
