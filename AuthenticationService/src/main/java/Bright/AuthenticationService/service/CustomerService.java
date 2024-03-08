package Bright.AuthenticationService.service;

import Bright.AuthenticationService.entity.Customer;
import Bright.AuthenticationService.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer registerCustomer(Customer customer) {
        // Additional validation and business logic can be added here
        return customerRepository.save(customer);
    }
}

