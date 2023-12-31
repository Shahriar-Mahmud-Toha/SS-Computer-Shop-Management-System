package dev.service;

import dev.domain.Customer;
import dev.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void createCustomer(Customer customer){
        customerRepository.createCustomer(customer);

    }

    public Customer signIn(String email, String password) {
        Customer customer = customerRepository.findByEmail(email);

        if (customer != null && customer.getPassword().equals(password)) {
            return customer;
        }

        return null; // Sign-in failed
    }

}
