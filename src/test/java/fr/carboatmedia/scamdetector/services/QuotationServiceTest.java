package fr.carboatmedia.scamdetector.services;

import fr.carboatmedia.scamdetector.models.Vehicle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuotationServiceTest {

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void computeScore_AnyDeal_35000() {
        Vehicle vehicle = new Vehicle();

        double rate = QuotationService.computeRate(vehicle);

        assertEquals(35000, rate);
    }
}
