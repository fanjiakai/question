package com.question.common.utils;


import com.google.gson.Gson;

import java.util.UUID;

public class Tool {
  public static <T> T fromJson(String json, Class<T> classOfT) {
    Gson gson = new Gson();
    return gson.fromJson(json, classOfT);
  }

  public static String generateUuid() {
    return UUID.randomUUID().toString().replaceAll("-", "");
  }

  public static Integer boolToInt(boolean b) {
    if (b) {
      return 1;
    } else {
      return 0;
    }
  }

  public static boolean intToBool(int number) {
    return number != 0;
  }

  public static int max(int a, int b) {
    if (a > b) {
      return a;
    } else {
      return b;
    }
  }

  public static String NumberToFix(String number,Integer length){
    Integer l=length+1;
    if(number.contains(".")){
      return number.substring(0,number.indexOf(".")+l);
    }else {
      StringBuilder  result=new StringBuilder();
      result.append(number);
      result.append(".");
      for (int i = 0; i <length ; i++) {
        result.append("0");
      }
      return String.valueOf(result);
    }
  }
  public static String NumberToFix(Object number,Integer length){
    String a=String.valueOf(number);
    return NumberToFix(a,length);
  }
}
