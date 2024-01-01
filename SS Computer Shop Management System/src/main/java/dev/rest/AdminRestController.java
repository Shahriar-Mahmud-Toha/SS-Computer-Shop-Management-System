package dev.rest;

import dev.domain.Admin;
import dev.domain.User;
import dev.service.AdminService;
import dev.service.UsersService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class AdminRestController {
    private AdminService adminService;
    private UsersService usersService;

    public AdminRestController(AdminService adminService, UsersService usersService)  {
        this.adminService = adminService;
        this.usersService = usersService;
    }

    @GetMapping("/admins")
    public List<Admin> getAllAdmins() throws SQLException {
        return adminService.getAllAdmins();
    }
    @GetMapping("/admins/{email}")
    public Admin getAdminByEmail(@PathVariable String email) throws SQLException {
        return adminService.getAdminByEmail(email);
    }
    @PostMapping("/admins/create")
    public String createAdmin(@Valid @RequestBody Admin admin, BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
            return "failed";
        }
        else {
            if(usersService.getUserByEmail(admin.getEmail())==null){
                return "Account Not Registered";
            }
            if(adminService.getAdminByEmail(admin.getEmail()) == null){
                adminService.create(admin);
                return "Success";
            }
            return "Account already exist";
        }
    }
    @PostMapping("/admins/update")
    public String updateAdmin(@Valid @RequestBody Admin admin, BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
            return "Invalid Model Format";
        }
        var data = adminService.getAdminByEmail(admin.getEmail());
        if(data==null){
            return "No Entry Found for this email";
        }
        admin.setId(data.getId());
        adminService.updateAdmin(admin);
        return "Success";
    }
    @GetMapping("/admins/delete/{id}")
    public String deleteAdminById(@PathVariable int id) throws SQLException {
        if(adminService.deleteAdminById(id)){
            return "Success";
        }
        return "Failed";
    }
    @GetMapping("/admins/deleteByEmail/{email}")
    public String deleteAdminByEmail(@PathVariable String email) throws SQLException {
        try {
            if(adminService.deleteAdminByEmail(email)){
                return "Success";
            }
            return "No Email Found";
        }
        catch (Exception exception){
            return exception.getMessage();
        }
    }
}
