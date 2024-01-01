package dev.rest;

import dev.domain.Customer;
import dev.domain.CustomerSignup;
import dev.domain.User;
import dev.service.CustomerService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@CrossOrigin(origins = "http://localhost:7000")
@RestController
public class CustomerRestController {
    private CustomerService customerService;

    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/register")
    public String createCustomer(@RequestBody CustomerSignup customerSignup) { // Use CustomerSignup class instead of Customer
        System.out.println("i am called"+ customerSignup.getEmail() +" "+ customerSignup.getPassword() + " "+ customerSignup.getName());
        customerService.createCustomer(customerSignup);
        return "Account Created";
    }

//    @PostMapping("/signin")
//    public String signIn(@RequestBody CustomerSignin signInRequest) {
//        String email = signInRequest.getEmail();
//        String password = signInRequest.getPassword();
//
//        Customer signedInCustomer = customerService.signIn(email, password);
//
//        if (signedInCustomer != null) {
//            return "Sign-in successful";
//        } else {
//            return "Sign-in failed";
//        }
//    }

    @PostMapping("/signin")
    public String signIn(@RequestBody CustomerSignup signInRequest, HttpServletResponse response) {
        String email = signInRequest.getEmail();
        String password = signInRequest.getPassword();

        User signedInCustomer = customerService.signIn(email, password);

        if (signedInCustomer != null) {
            // Create a cookie with the user's email
            Cookie userEmailCookie = new Cookie("userEmail", email);
            // Set the cookie's expiration time (e.g., 7 days)
            userEmailCookie.setMaxAge(60 * 60 * 24 * 7);
            // Add the cookie to the response
            response.addCookie(userEmailCookie);

            return "Sign-in successful";
        } else {
            return "Sign-in failed";
        }
    }




}
