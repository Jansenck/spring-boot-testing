package dio.aulas.controller;

import dio.aulas.model.User;
import dio.aulas.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping
    @Operation(summary = "Get all users")
    public List<User> list(){
        return service.listUsers();
    }

    @GetMapping("/{username}")
    @Operation(summary = "Get a user by username")
    public User find(@PathVariable("username") String username){
        return service.getUserByUsername(username);
    }

    @PostMapping
    @Operation(summary = "Post a new user")
    public void postUser(@RequestBody User user){
        service.createUser(user);
    }

    @PutMapping
    @Operation(summary = "Update a user")
    public void update(@RequestBody User user){
        service.updateUser(user);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a user")
    public void delete(@PathVariable("id") Integer id){
        service.deleteUserById(id);
    }
}

