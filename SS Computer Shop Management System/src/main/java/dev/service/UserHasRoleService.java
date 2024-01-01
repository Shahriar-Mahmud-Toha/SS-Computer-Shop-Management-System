package dev.service;

import dev.domain.UserHasRole;
import dev.repository.RoleRepository;
import dev.repository.UserHasRoleRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserHasRoleService {
    private UserHasRoleRepository userHasRoleRepository;

    public UserHasRoleService(UserHasRoleRepository userHasRoleRepository) {
        this.userHasRoleRepository = userHasRoleRepository;
    }

    public List<UserHasRole> getAllUserHasRole() {
        return userHasRoleRepository.getAllUserHasRole();
    }
    public int getUserRoleIdByEmail(String email) {
        return userHasRoleRepository.getUserRoleIdByEmail(email);
    }
    public void save(UserHasRole userHasRole) {
        userHasRoleRepository.save(userHasRole);
    }
}
