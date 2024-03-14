package Bright.AuthenticationService.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Address {

    private String street;
    private String city;
    private String state;
    private String postalCode;

    // Constructors, getters, and setters
}
