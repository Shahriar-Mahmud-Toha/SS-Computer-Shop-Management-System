package dev.rest;

import dev.domain.Admin;
import dev.domain.User;
import dev.service.UsersService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    @PostMapping("/users/create")
    public String createUser(@Valid @RequestBody User user, BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
            return "failed";
        }
        else {
            if(usersService.save(user,"ROLE_ADMIN")){
                return "Account Created Successfully";
            }
            else {
                return "An Account with this Email already exist";
            }
        }
    }

    @GetMapping("/users/delete/{email}")
    public String deleteUser(@PathVariable String email) throws SQLException {
        if(usersService.deleteUserByEmail(email)){
            return "Account Deleted";
        }
        else {
            return "Account NOT Deleted";
        }
    }
    @PostMapping("/users/updateUser")
    public String updateUser(@Valid @RequestBody User user, BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
            return "failed";
        }
        else {
            if(usersService.updateUser(user)){
                return "Account Updated Successfully";
            }
            else {
                return "Account Not Updated";
            }
        }
    }
    @PostMapping("/users/loginAdmin")
    public String UserLoginForAdmin(@Valid @RequestBody User user, BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
            return "failed";
        }
        else {
            if(usersService.isValidAdmin(user.getEmail(),user.getPassword()) != null ){
                return "Login Successful";
            }
            else {
                return "Invalid Credentials";
            }
        }
    }
}
