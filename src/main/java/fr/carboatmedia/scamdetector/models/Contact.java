package fr.carboatmedia.scamdetector.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Contact {

    private String firstName;
    private String lastName;
    private String email;

    @JsonProperty("phone")
    @JsonAlias("phone1")
    private Phone phone;

    public Contact() {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Phone getPhone() {
        return phone;
    }
}
