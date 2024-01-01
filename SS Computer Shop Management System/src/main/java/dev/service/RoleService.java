package dev.service;

import dev.domain.Admin;
import dev.repository.AdminRepository;
import dev.repository.RoleRepository;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RoleService {
    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public int getRoleIdByName(String name){
        return roleRepository.getRoleIdByName(name);
    }
}
