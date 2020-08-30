package fr.carboatmedia.scamdetector.services;

import fr.carboatmedia.scamdetector.models.Vehicle;

public class QuotationService {

    public static double computeRate(Vehicle vehicle) {
        try {
            Thread.sleep(50);
        } catch (Exception ignored) {
        }

        return 35000;
    }
}
