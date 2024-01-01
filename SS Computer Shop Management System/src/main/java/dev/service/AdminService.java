package dev.service;

import dev.domain.Admin;
import dev.domain.User;
import dev.repository.AdminRepository;
import dev.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AdminService {
    private AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<Admin> getAllAdmins(){
        return adminRepository.getAllAdmins();
    }
    public Admin getAdminByEmail(String email) {
        return adminRepository.getAdminByEmail(email);
    }
    public void create(Admin admin) {
        adminRepository.create(admin);
    }
    public void updateAdmin(Admin admin) {
        adminRepository.updateAdmin(admin);
    }
    public boolean deleteAdminById(int id) {
        return adminRepository.deleteAdminById(id);
    }
}
