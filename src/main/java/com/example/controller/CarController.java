package com.example.controller;

import com.example.model.Car;
import com.example.service.CarService;
import com.example.web.client.PricingServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    CarService carService;

    @GetMapping("/greet")
    public String index() {
        return carService.greet();
    }

    @GetMapping("/all")
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("/{id}")
    public Car getCar(@PathVariable Long id) {
        return carService.getCarById(id);
    }

    @GetMapping("/{id}/price")
    public Car getCarWithPrice(@PathVariable Long id) {
        return carService.getCarWithPrice(id);
    }

}
