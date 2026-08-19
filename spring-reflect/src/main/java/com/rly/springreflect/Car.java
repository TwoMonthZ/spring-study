package com.rly.springreflect;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Car {

    private String name;
    private int age;
    private String color;


    private void run(){
        System.out.println("私有方法 ");
    }
}
