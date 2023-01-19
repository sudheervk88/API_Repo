package com.utils;

import com.constants.FrameworkConstants;
import com.enums.PropertyType;
import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public final class PropertyUtils {

    private static Properties properties = new Properties();
    private static Map<String,String> MAP = new HashMap<>();

    private PropertyUtils(){

    }

    // static block will be instantiated automatically
    // In this implementation (try block with resources)program will terminate in case any exception

    static{
        try(FileInputStream fileInputStream = new FileInputStream(FrameworkConstants.propertyFilePath)) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
        properties.entrySet().forEach(e->MAP.put(String.valueOf(e.getKey()),String.valueOf(e.getValue())));
    }

    public static String getValue(PropertyType key){
        return MAP.get(key.name().toLowerCase());
    }

}
