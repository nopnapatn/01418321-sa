package ku.cs.sa.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ku.cs.sa.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    User findByUsername(String username);

    User findByEmail(String email);
}
