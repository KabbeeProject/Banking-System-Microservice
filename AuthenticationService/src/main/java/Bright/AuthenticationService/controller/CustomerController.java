package Bright.AuthenticationService.controller;

import Bright.AuthenticationService.entity.Address;
import Bright.AuthenticationService.entity.Customer;
import Bright.AuthenticationService.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
//@CrossOrigin
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;
    private final BCryptPasswordEncoder passwordEncoder;
     @Autowired
    public CustomerController(CustomerService customerService, BCryptPasswordEncoder passwordEncoder) {
        this.customerService = customerService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerCustomer(@RequestBody Customer customer) {
        // Check if there is an existing user with the same email, SSN, or phone number
        if (customerService.existsByUsername(customer.getUsername())|| customerService.existsByEmail(customer.getEmail()) ||
                customerService.existsBySsn(customer.getSsn()) ||
                customerService.existsByPhoneNumber(customer.getPhoneNumber())) {
            String errorMessage = "A user with the same username, email, SSN, or phone number already exists";
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        }

        // Encrypt the password before saving
        String encryptedPassword = passwordEncoder.encode(customer.getPassword());
        customer.setPassword(encryptedPassword);

        // Save the customer
        customerService.registerCustomer(customer);

        String message = "Customer registered successfully";
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @PutMapping("/update/{username}")
    public ResponseEntity<String> updateCustomer(@PathVariable String username, @RequestBody Customer updatedCustomer) {
        // Find the existing customer by username
        Optional<Customer> existingCustomerOptional = customerService.findByUsername(username);

        if (existingCustomerOptional.isPresent()) {
            // Customer found, update the details
            Customer existingCustomer = existingCustomerOptional.get();

            // Update fields with non-null values from the updatedCustomer
            if (updatedCustomer.getFirstName() != null) {
                existingCustomer.setFirstName(updatedCustomer.getFirstName());
            }

            if (updatedCustomer.getLastName() != null) {
                existingCustomer.setLastName(updatedCustomer.getLastName());
            }

            if (updatedCustomer.getEmail() != null) {
                existingCustomer.setEmail(updatedCustomer.getEmail());
            }

            if (updatedCustomer.getPassword() != null) {
                existingCustomer.setPassword(updatedCustomer.getPassword());
            }

            if (updatedCustomer.getUsername() != null) {
                existingCustomer.setUsername(updatedCustomer.getUsername());
            }

            if (updatedCustomer.getDateOfBirth() != null) {
                existingCustomer.setDateOfBirth(updatedCustomer.getDateOfBirth());
            }

            if (updatedCustomer.getGender() != null) {
                existingCustomer.setGender(updatedCustomer.getGender());
            }

            if (updatedCustomer.getPhoneNumber() != null) {
                existingCustomer.setPhoneNumber(updatedCustomer.getPhoneNumber());
            }

            if (updatedCustomer.getAddress() != null) {
                // Assuming Address has its own fields (street, city, state, postalCode)
                Address updatedAddress = updatedCustomer.getAddress();
                Address existingAddress = existingCustomer.getAddress();

                if (updatedAddress.getStreet() != null) {
                    existingAddress.setStreet(updatedAddress.getStreet());
                }

                if (updatedAddress.getCity() != null) {
                    existingAddress.setCity(updatedAddress.getCity());
                }

                if (updatedAddress.getState() != null) {
                    existingAddress.setState(updatedAddress.getState());
                }

                if (updatedAddress.getPostalCode() != null) {
                    existingAddress.setPostalCode(updatedAddress.getPostalCode());
                }
            }

            if (updatedCustomer.getCountry() != null) {
                existingCustomer.setCountry(updatedCustomer.getCountry());
            }

            if (updatedCustomer.getSsn() != null) {
                existingCustomer.setSsn(updatedCustomer.getSsn());
            }

            // Save the updated customer using Spring Data JPA repository
//            customerRepository.save(existingCustomer);
            customerService.registerCustomer(existingCustomer);

            String successMessage = "Customer updated successfully";
            return new ResponseEntity<>(successMessage, HttpStatus.OK);
        } else {
            // Customer not found
            String errorMessage = "Customer with username " + username + " not found";
            return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/{username}")
    public ResponseEntity<?> getCustomerByUsername(@PathVariable String username) {
        Optional<Customer> customerOptional = customerService.findByUsername(username);

        if (customerOptional.isPresent()) {
            Customer customer = customerOptional.get();
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } else {
            String errorMessage = "Customer with username " + username + " not found";
            return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
        }
    }
}