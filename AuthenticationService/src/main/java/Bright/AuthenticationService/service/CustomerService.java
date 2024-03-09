package Bright.AuthenticationService.service;

import Bright.AuthenticationService.entity.Customer;
import Bright.AuthenticationService.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
import java.util.Optional;

=======
>>>>>>> login/Msgun
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
<<<<<<< HEAD
    public boolean existsByEmail(String email) {
        return customerRepository.existsByEmail(email);
    }

    public boolean existsBySsn(String ssn) {
        return customerRepository.existsBySsn(ssn);
    }
    public boolean existsByUsername(String username) {
        return customerRepository.existsByUsername(username);
    }


    public boolean existsByPhoneNumber(String phoneNumber) {
        return customerRepository.existsByPhoneNumber(phoneNumber);
    }

    public Optional<Customer> findByUsername(String username) {
        return customerRepository.findByUsername(username);
    }
=======
>>>>>>> login/Msgun
}

