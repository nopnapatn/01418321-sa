package ku.cs.sa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ku.cs.sa.models.User;
import ku.cs.sa.repositories.UserRepository;

@Service
public class AuthService {
    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean isUsernameAvaliable(String username) {
        return repository.findByUsername(username) == null;
    }

    public boolean isEmailAvaliable(String email) {
        return repository.findByEmail(email) == null;
    }

    public void createUser(User user) {
        User record = new User();
        record.setEmail(user.getEmail());
        record.setUsername(user.getUsername());
        record.setName(user.getName());
        record.setRole("ROLE_USER");

        String hashedPassword = passwordEncoder.encode(user.getPassword());
        record.setPassword(hashedPassword);

        repository.save(record);
    }

    public User getEmail(String email) {
        return repository.findByUsername(email);
    }

}
