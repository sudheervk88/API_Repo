package com.utils;

import com.github.javafaker.Faker;

public class RandomUtils {

    private RandomUtils(){

    }


    public static int getId(int minVal,int maxVal){

        return FakerUtils.generateID(minVal,maxVal);
    }

    public static int getId(){

        return FakerUtils.generateID(0,500);
    }

    public static String getFirstName(){

        return FakerUtils.generateFirstName();
    }

    public static String getLastName(){

        return FakerUtils.generateLastName();
    }

    public static String getJob(){

        return FakerUtils.generateJob();
    }
}
