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

    public AdminRestController(AdminService adminService)  {
        this.adminService = adminService;
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
            if(adminService.getAdminByEmail(admin.getEmail()) == null){
                adminService.create(admin);
                return "Success";
            }
            return "Account already exist";
        }
    }
    @PostMapping("/admins/update")
    public String updateAdmin(@RequestBody Admin admin) throws SQLException {
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
}
