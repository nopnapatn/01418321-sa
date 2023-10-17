package ku.cs.sa.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ku.cs.sa.Entities.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, UUID> {

}
