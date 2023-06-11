package com.utils;

public final class StringUtils {


    private StringUtils(){

    }

    public static String replaceIllegal(String message){
        return   message.
              replaceAll("\n","").
              replaceAll("\r","").
              replaceAll("\"","\\\\\"");
    }




}
