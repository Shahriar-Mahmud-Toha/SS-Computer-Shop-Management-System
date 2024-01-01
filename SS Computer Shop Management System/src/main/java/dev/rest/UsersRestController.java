package dev.rest;

import dev.domain.Categories;
import dev.domain.User;
import dev.service.CategoriesService;
import dev.service.UsersService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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

}
