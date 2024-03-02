package Bright.AuthenticationService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String username;
    private LocalDate dateOfBirth;
    private String gender;
    private String phoneNumber;

    @Embedded
    private Address address;

    private String country;
    private String ssn;

    // Constructors, getters, and setters

    // Additional methods if needed
}