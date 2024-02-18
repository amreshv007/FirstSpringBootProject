package com.example.springboot.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;


@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {
    @NonNull
    String name;
    int age;
    String college;
    @JsonIgnore
    String curr_company;

//    public Person(String name, int age, String college, String currCompany) {
//        this.name = name;
//        this.age = age;
//        this.college = college;
//        this.curr_company = currCompany;
//    }
}
