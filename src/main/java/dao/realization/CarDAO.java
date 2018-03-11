package dao.realization;

import domain.Car;

import java.util.List;

public interface CarDAO {

    Car addCar(Car car);

    List<Car> getAll();
}
