package com.student;

import lombok.Builder;
import lombok.Getter;

@Builder(setterPrefix = "set")
@Getter
public class Student {

    private int id;
    private String studentName;
    private String lastName;
    private String department;



}
