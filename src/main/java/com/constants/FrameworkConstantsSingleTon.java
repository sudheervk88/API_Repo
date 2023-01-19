package com.constants;

import lombok.Getter;

@Getter
public class FrameworkConstantsSingleTon {
     public static FrameworkConstantsSingleTon instance = null;

     private  FrameworkConstantsSingleTon(){

     }

      public static synchronized FrameworkConstantsSingleTon getInstance(){

         if(instance == null){
            instance = new FrameworkConstantsSingleTon();
         }
         return instance;
      }
      public final String requestJsonPath = System.getProperty("user.dir")+"/src/test/resources/jsons/";

      public final String responseJsonPath = System.getProperty("user.dir")+"/output/";

}
