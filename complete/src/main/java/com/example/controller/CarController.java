package com.example.controller;

import com.example.model.Car;
import com.example.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

	@Autowired
	CarService carService;

	@GetMapping("/greet")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@GetMapping("/all")
	public List<Car> getAllCars() {
		return carService.getAllCars();
	}

}
