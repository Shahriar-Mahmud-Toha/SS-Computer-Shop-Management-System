package dev.service;

import dev.domain.Categories;
import dev.domain.User;
import dev.repository.CategoriesRepository;
import dev.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UsersService {
    private UserRepository userRepository;

    public UsersService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.getAllUsers();
    }

    public String getUserPasswordByEmail(String email) {
        return userRepository.getUserPasswordByEmail(email);
    }
}
