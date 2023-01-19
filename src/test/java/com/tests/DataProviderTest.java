package com.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {



    @Test(dataProvider = "getData1")
    public void dpTest(String data1,String data2){

        System.out.println(data1);
        System.out.println(data2);

    }


    // first dimension[] indicates number of times needs to execute
    //second dimension[] indicates number of parameter to the method
     @DataProvider
    public Object[][] getData1(){
      return new Object[][]{
              {"abc", "def"},
              {"hij", "klm"},
              {"nop", "qrs"}
           };

    }


}
