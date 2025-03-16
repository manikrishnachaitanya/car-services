package com.example.model;

import lombok.*;

import java.beans.ConstructorProperties;


@ToString
@AllArgsConstructor
@Data
public class Car {
    private Long id;
    private String make;
    private String model;
    private Integer year;
}
