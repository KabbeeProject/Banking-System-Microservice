package Bright.AuthenticationService.repository;

import Bright.AuthenticationService.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD
import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    boolean existsByEmail(String email);

    boolean existsBySsn(String ssn);

    boolean existsByPhoneNumber(String phoneNumber);
    boolean existsByUsername(String username);
    // Additional query methods if needed
    Optional<Customer> findByUsername(String username);
=======
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    // Additional query methods if needed
>>>>>>> login/Msgun
}
