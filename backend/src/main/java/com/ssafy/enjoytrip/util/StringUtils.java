package com.ssafy.enjoytrip.util;

public class StringUtils {
    public static boolean isNull(String data){
        return data ==null;
    }
    public static boolean isBlank(String data){
        return isNull(data) || data.trim().equals("");
    }
}
