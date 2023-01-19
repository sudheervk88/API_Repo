package com.utils;

import com.github.javafaker.Faker;

public final class FakerUtils {

    private static final Faker faker = new Faker();
    private FakerUtils(){

    }

    public static int generateID(int minVal,int maxVal){

        return faker.number().numberBetween(minVal,maxVal);
    }

    public static String generateFirstName(){

        return faker.name().firstName();
    }

    public static String generateLastName(){

        return faker.name().lastName();
    }

    public static String generateJob(){

        return faker.job().field();
    }



}
