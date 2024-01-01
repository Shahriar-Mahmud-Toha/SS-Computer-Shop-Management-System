package dev.service;

import dev.domain.*;
import dev.repository.*;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CustomerService {
    private CustomerRepository customerRepository;
    private UserRepository userRepository;

    //private RoleRepository roleRepository;
    //private UserHasRoleRepository userHasRoleRepository;
    private CustomerProfitRepository customerProfitRepository;

    public CustomerService(CustomerRepository customerRepository, UserRepository userRepository, CustomerProfitRepository customerProfitRepository) {
        this.customerRepository = customerRepository;
        this.userRepository = userRepository;
        this.customerProfitRepository = customerProfitRepository;
    }

    public void createCustomer(CustomerSignup customerSignup) { // Update parameter to CustomerSignup
        userRepository.save(new User(customerSignup.getEmail(), customerSignup.getPassword()));
        customerRepository.save(new Customer(customerSignup.getEmail(), customerSignup.getName()));
//        Role defaultRole = roleRepository.findByName("USER"); // Assuming a default role
//        userHasRoleRepository.save(new UserHasRole(customerSignup.getEmail(), defaultRole.getId()));
       // customerProfitRepository.save(new CustomerProfit(customerSignup.getEmail(), 0));
    }

    public User signIn(String email, String password) {
        User user = userRepository.findByEmail(email);

        if (user != null && user.getPassword().equals(password)) {
            return user;
        }

        return null; // Sign-in failed
    }

}
