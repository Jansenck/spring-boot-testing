package dio.aulas.service;

import dio.aulas.model.User;
import dio.aulas.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> listUsers() {
        return repository.findAll();
    }
    public User getUserByUsername(String username) {
        return repository.findByUsername(username);
    }

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
    public void createUser(User user){
        String pass = user.getPassword();
        String encodedPassword = passwordEncoder.encode(pass);
        user.setPassword(encodedPassword);
        repository.save(user);
    }

    public void updateUser(User user) {
        String pass = user.getPassword();
        String encodedPassword = passwordEncoder.encode(pass);
        user.setPassword(encodedPassword);
        repository.save(user);
    }

    public void deleteUserById(Integer id) {
        repository.deleteById(id);
    }
}
