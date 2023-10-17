package ku.cs.sa.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ku.cs.sa.Entities.User;
import ku.cs.sa.models.SignupRequest;
import ku.cs.sa.repositories.UserRepository;

@Service
public class AuthService {
    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper modelMapper;

    public boolean isUsernameAvaliable(String username) {
        return repository.findByUsername(username) == null;
    }

    public boolean isEmailAvaliable(String email) {
        return repository.findByEmail(email) == null;
    }

    public void createUser(SignupRequest user) {
        User record = modelMapper.map(user, User.class);
        record.setRole("ROLE_USER");

        String hashedPassword = passwordEncoder.encode(user.getPassword());
        record.setPassword(hashedPassword);

        repository.save(record);
    }

    public User getEmail(String email) {
        return repository.findByUsername(email);
    }

}
