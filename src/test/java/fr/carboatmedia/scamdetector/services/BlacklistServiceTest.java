package fr.carboatmedia.scamdetector.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BlacklistServiceTest {
    
    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void isBlacklisted_registerNumberIsAA123AA_true() {
        boolean isBlacklisted = BlacklistService.isBlacklisted("AA123AA");

        assertTrue(isBlacklisted);
    }

    @Test
    void isBlacklisted_registerNumberIsAA123BB_false() {
        boolean isBlacklisted = BlacklistService.isBlacklisted("AA123BB");

        assertFalse(isBlacklisted);
    }
}
