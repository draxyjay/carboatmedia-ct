package fr.carboatmedia.scamdetector.models;

public class Vehicle {

    private String make;
    private String model;
    private String version;
    private String category;
    private String registerNumber;
    private int mileage;

    public Vehicle() {
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getVersion() {
        return version;
    }

    public String getCategory() {
        return category;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public int getMileage() {
        return mileage;
    }
}
