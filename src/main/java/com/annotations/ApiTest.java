package com.annotations;

import org.testng.annotations.Test;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Test()
public @interface ApiTest {


}
