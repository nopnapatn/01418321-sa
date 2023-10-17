package ku.cs.sa.Entities;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Car {
    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private double price;
}
