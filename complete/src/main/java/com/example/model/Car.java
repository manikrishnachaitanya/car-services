package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.beans.ConstructorProperties;


@ToString
@Getter
@Setter
@AllArgsConstructor
public class Car {
    private String make;
    private String model;
    private Integer year;
}
