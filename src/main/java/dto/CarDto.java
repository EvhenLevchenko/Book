package dto;

import domain.Car;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)//this update model
public class CarDto {

    private Long carId;
    private String model;


    public static Car fromDto(CarDto carDto) {
        return Car.builder()
                .carId(carDto.carId)
                .model(carDto.model)
                .build();
    }

    public static CarDto toDto(Car car) {
        return CarDto.builder()
                .carId(car.getCarId())
                .model(car.getModel())
                .build();
    }
}
