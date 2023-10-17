package ku.cs.sa.models;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue
    private UUID id;

    private String email;
    private String username;
    private String password;
    private String name;
    private String role;
}
