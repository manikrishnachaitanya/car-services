package com.example.service;

import com.example.model.Car;
import com.example.web.client.PricingServiceClient;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
public class CarService {

    @Autowired
    PricingServiceClient pricingServiceClient;

    private static final Logger log = LoggerFactory.getLogger(CarService.class);
    private List<Car> cars = new ArrayList<>();

    @PostConstruct
    public void setCars() {
        Car car1 = new Car(1231L,"toyota", "corolla", 2006, null);
        cars.add(car1);
        Car car4 = new Car(1232L, "toyota", "camry", 20019, null);
        cars.add(car4);
        Car car2 = new Car(1233L, "honda", "civic", 2010, null);
        cars.add(car2);
        Car car3 = new Car(1234L, "mazda", "cx-5", 2008, null);
        cars.add(car3);
    }

    public String greet() {
        log.info("Sending greeting");
        return "Welcome to the Car Auction system!!!";
    }

    public List<Car> getAllCars() {
        log.trace(" >> getAllCars");
        log.info("Returning all cars");
        return cars;
    }

    public Car getCarById(Long id) {
        log.trace(" >> getCarById");
        log.info("input ID : {}", id);
        Optional<Car> optionalCar = cars.stream().filter(car0 -> Objects.equals(car0.getId(), id)).findAny();
        if (optionalCar.isPresent()) {
            log.info("Car found with id {}", id);
            return optionalCar.get();
        }
        else {
            log.info("Car not found with id {}", id);
        }
        log.trace(" << getCarById");
        return null;
    }

    public Car getCarWithPrice(Long id) {
        Car car = getCarById(id);
        log.info("Car found : {}", car);
        try {
            Integer price = pricingServiceClient.getPriceEstimate(car).block();
            car.setPrice(price);
        }
        catch (Exception exception) {
            log.error("Exception while getting price", exception);
        }
        return car;
    }

}
