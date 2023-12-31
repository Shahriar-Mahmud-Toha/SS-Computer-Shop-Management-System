package dev.rest;

import dev.domain.Customer;
import dev.domain.CustomerSignin;
import dev.service.CustomerService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:7000")
@RestController
public class CustomerRestController {
    private CustomerService customerService;

    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/register")
    public String createCustomer(@RequestBody Customer customer){

         customerService.createCustomer(customer);
         return "Account Created";

    }

    @PostMapping("/signin")
    public String signIn(@RequestBody CustomerSignin signInRequest) {
        String email = signInRequest.getEmail();
        String password = signInRequest.getPassword();

        Customer signedInCustomer = customerService.signIn(email, password);

        if (signedInCustomer != null) {
            return "Sign-in successful";
        } else {
            return "Sign-in failed";
        }
    }



}
