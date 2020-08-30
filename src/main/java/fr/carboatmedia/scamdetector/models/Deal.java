package fr.carboatmedia.scamdetector.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

public class Deal {

    private String reference;

    @JsonProperty("contact")
    @JsonAlias("contacts")
    private Contact contact;

    private Vehicle vehicle;
    private double price;
    private Date creationDate;
    private List<String> publicationOptions;

    public Deal() {
    }

    public String getReference() {
        return reference;
    }

    public Contact getContact() {
        return contact;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public double getPrice() {
        return price;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public List<String> getPublicationOptions() {
        return publicationOptions;
    }
}
