package Bright.AuthenticationService.repository;

import Bright.AuthenticationService.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    // Additional query methods if needed
}
