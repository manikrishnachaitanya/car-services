package com.example.model;

import lombok.*;
import org.springframework.lang.Nullable;

import java.beans.ConstructorProperties;


@ToString
@AllArgsConstructor
@Data
public class Car {
    private Long id;
    private String make;
    private String model;
    private Integer year;
    private Integer price;
}
