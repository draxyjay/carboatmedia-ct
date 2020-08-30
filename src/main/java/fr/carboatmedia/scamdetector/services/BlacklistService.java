package fr.carboatmedia.scamdetector.services;

public class BlacklistService {

    public static boolean isBlacklisted(String registerNumber) {
        try {
            Thread.sleep(50);
        } catch (Exception ignored) {
        }

        return registerNumber.equalsIgnoreCase("AA123AA");
    }
}
