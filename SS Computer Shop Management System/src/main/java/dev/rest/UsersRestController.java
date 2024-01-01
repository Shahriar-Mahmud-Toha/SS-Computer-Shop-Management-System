package dev.rest;

import dev.domain.Admin;
import dev.domain.User;
import dev.service.UsersService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

//@CrossOrigin(origins = "http://localhost:7000")
@RestController
public class UsersRestController {
    private UsersService usersService;

    public UsersRestController(UsersService usersService)  {
        this.usersService = usersService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() throws SQLException {
        return usersService.getAllUsers();
    }
    @GetMapping("/users/{email}")
    public User getUserByEmail(@PathVariable String email) throws SQLException {
        return usersService.getUserByEmail(email);
    }
}
