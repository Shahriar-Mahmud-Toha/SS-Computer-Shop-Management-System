package dev.service;

import dev.domain.Admin;
import dev.domain.User;
import dev.domain.UserHasRole;
import dev.repository.RoleRepository;
import dev.repository.UserHasRoleRepository;
import dev.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UsersService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private UserHasRoleRepository userHasRoleRepository;

    public UsersService(UserRepository userRepository, RoleRepository roleRepository, UserHasRoleRepository userHasRoleRepository) {
        this.userRepository = userRepository;
        this.userHasRoleRepository = userHasRoleRepository;
        this.roleRepository = roleRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.getAllUsers();
    }

    public String getUserPasswordByEmail(String email) {
        return userRepository.getUserPasswordByEmail(email);
    }
    public User getUserByEmail(String email){
        return userRepository.findByEmail(email);
    }
    public boolean save(User user, String role_name) {
        try {
            var role_id = roleRepository.getRoleIdByName(role_name);
            var data = userRepository.getUserByEmail(user.getEmail());
            if(data!=null || role_id==(-1)){
                return false;
            }
            userRepository.save(user);
            UserHasRole userHasRole = new UserHasRole();
            userHasRole.setEmail(user.getEmail());
            userHasRole.setRole_id(role_id);
            userHasRoleRepository.save(userHasRole);
            return true;
        }
        catch (Exception exception){
            return false;
        }
    }
}
