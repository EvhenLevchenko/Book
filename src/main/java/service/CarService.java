package service;

import dao.realization.hibernate.CarDAOImpl;
import domain.Car;
import dto.CarDto;

import java.util.List;
import java.util.stream.Collectors;

public class CarService {
    private CarDAOImpl carDAO = new CarDAOImpl();

    public CarDto addCar(CarDto carDto) {
        Car car = carDAO.addCar(CarDto.fromDto(carDto));
        return CarDto.toDto(car);
    }

    public List<CarDto> getAll() {
        return carDAO.getAll().stream()
                .map(car -> CarDto.toDto(car))
                .collect(Collectors.toList());
    }
}
