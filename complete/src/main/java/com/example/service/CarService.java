package com.example.service;

import com.example.model.Car;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    private List<Car> cars = new ArrayList<>();

    @PostConstruct
    public void setCars() {
        Car car1 = new Car("toyota", "corolla", 2006);
        cars.add(car1);
        Car car2 = new Car("honda", "civic", 2010);
        cars.add(car2);
        Car car3 = new Car("mazda", "cx-5", 2008);
        cars.add(car3);
    }

    public List<Car> getAllCars() {
        return cars;
    }
}
