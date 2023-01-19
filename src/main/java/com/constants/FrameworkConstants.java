package com.constants;

import lombok.Getter;

public class FrameworkConstants {


    public static @Getter final String requestJsonPath = System.getProperty("user.dir")+"/src/test/resources/jsons/";
    public static @Getter final String responseJsonPath = System.getProperty("user.dir")+"/output/";
    public static @Getter final String propertyFilePath = System.getProperty("user.dir")+"/src/test/resources/config.properties";



}
