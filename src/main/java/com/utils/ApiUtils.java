package com.utils;

import io.restassured.response.Response;
import lombok.SneakyThrows;
import java.nio.file.Files;
import java.nio.file.Paths;

public final class ApiUtils {


    private ApiUtils() {

    }

    @SneakyThrows
    public static String readJsonAsString(String path){
        return new String(Files.readAllBytes(Paths.get(path)));
    }

    @SneakyThrows
    public static void storeResponseAsJson(String path, Response response){

        Files.write(Paths.get(path),response.asByteArray());
    }

}
