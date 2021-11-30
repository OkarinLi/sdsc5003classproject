package com.cityu.sdsc5003classproject.util;

public class StringTool {
    public static Boolean isNotBlank(String s){
        if(s ==null || s.trim().length() == 0) return false;
        return true;
    }

}
