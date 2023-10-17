package ku.cs.sa.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ku.cs.sa.Entities.Car;
import ku.cs.sa.models.CarRequest;
import ku.cs.sa.repositories.CarRepository;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    @Autowired
    private ModelMapper modelMapper;

    public java.util.List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public void createCar(CarRequest request) {
        Car record = modelMapper.map(request, Car.class);
        carRepository.save(record);
    }
}
