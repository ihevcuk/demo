package hr.omegasoftware.iot.demo.controller;

import hr.omegasoftware.iot.demo.model.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
public class TestController {

    // localhost:8080/findCar?color=zelena
    @GetMapping("/findCar")
    public List<Car> search(String color) {
        List<Car> data = Arrays.asList(
                new Car("Zelena", 5000L, 3),
                new Car("Crvena", 5000L, 3),
                new Car("Plava", 5000L, 3),
                new Car("Plava", 5000L, 3),
                new Car("Zelena", 5000L, 3),
                new Car("Zuta", 5000L, 3),
                new Car("Zelena", 5000L, 3)
        );

        return data.stream().filter(car -> car.getColor().equalsIgnoreCase(color)).collect(Collectors.toList());
    }

    // localhost:8080/findCar/zelena
    @GetMapping("/findCar/{color}")
    public List<Car> searchVersion2(@PathVariable String color) {
        List<Car> data = Arrays.asList(
                new Car("Zelena", 5000L, 3),
                new Car("Crvena", 5000L, 3),
                new Car("Plava", 5000L, 3),
                new Car("Plava", 5000L, 3),
                new Car("Zelena", 5000L, 3),
                new Car("Zuta", 5000L, 3),
                new Car("Zelena", 5000L, 3)
        );

        return data.stream().filter(car -> car.getColor().equalsIgnoreCase(color)).collect(Collectors.toList());
    }

    @GetMapping("/my-car")
    public boolean hello() {
        Car car = new Car();
        car.setColor("Zelena");
        car.setPrice(5000L);
        car.setAge(3);
        //car.squarePrice();

        Car car1 = new Car();
        car1.setColor("Plava");
        car1.setPrice(5000L);
        car1.setAge(3);

        boolean isEqual = car.equals(car1);

        return isEqual;
    }

    @PostMapping("/my-car")
    public Car write(@RequestBody Car car) {
        // ... unos u bazu
        log.info("Dosao mi je auto: {}", car);

        car.setColor("Red");
        return car;
    }

}
