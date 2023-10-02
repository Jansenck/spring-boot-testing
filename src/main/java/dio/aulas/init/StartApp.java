package dio.aulas.init;

import dio.aulas.model.User;
import dio.aulas.repository.UserRepository;
import dio.aulas.service.UserService;
import jakarta.transaction.Transactional;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartApp implements CommandLineRunner {
    @Autowired
    private UserService service;
    @Transactional
    @Override
    public void run(String... args) throws Exception {
        User user = service.getUserByUsername("admin");

        if(user==null) {
            user = new User();
            user.setName("ADMIN");
            user.setUsername("admin");
            user.setPassword("111");
            user.getRoles().add("MANAGERS");
            service.createUser(user);
        }

        user = service.getUserByUsername("user");
        if(user==null) {
            user = new User();
            user.setName("USER");
            user.setUsername("user");
            user.setPassword("123");
            user.getRoles().add("MANAGERS");
            service.createUser(user);
        }
    }
}
