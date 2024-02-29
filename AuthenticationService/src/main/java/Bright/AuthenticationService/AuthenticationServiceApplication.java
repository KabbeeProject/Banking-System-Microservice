package Bright.AuthenticationService;

import Bright.AuthenticationService.entity.Customer;
import Bright.AuthenticationService.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AuthenticationServiceApplication
//		implements CommandLineRunner
{

	@Autowired
	CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationServiceApplication.class, args);
		System.out.println("Authenticatioon service is running");
//		Customer customer1 = new Customer(null, "Musie", "Fanuel");


	}

//	@Override
//	public void run(String... args) throws Exception {
//		Customer customer1 = new Customer(null, "Musie", "Fanuel");
//		customerRepository.save(customer1);
//	}
}
