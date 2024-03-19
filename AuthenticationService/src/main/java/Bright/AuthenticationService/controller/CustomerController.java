package Bright.AuthenticationService.controller;

import Bright.AuthenticationService.entity.Customer;
import Bright.AuthenticationService.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerCustomer(@RequestBody Customer customer) {
        customerService.registerCustomer(customer);
        String message = "Customer registered successfully";
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    // Additional endpoints for retrieving customer information, updating, or deleting
}