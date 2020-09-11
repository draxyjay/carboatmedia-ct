package fr.carboatmedia.scamdetector.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.carboatmedia.scamdetector.models.Analysis;
import fr.carboatmedia.scamdetector.models.Contact;
import fr.carboatmedia.scamdetector.models.Deal;
import fr.carboatmedia.scamdetector.models.Vehicle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ScamDetectorServiceTest {

    @InjectMocks
    private ObjectMapper mapper;

    ScamDetectorService scamDetectorService;

    @BeforeEach
    void setup() {
        scamDetectorService = new ScamDetectorService();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void analyze_DealIsScam_TrueWithTwoRules() throws JsonProcessingException {
        Deal deal = mock(Deal.class);
        Contact contact = mock(Contact.class);
        Vehicle vehicle = mock(Vehicle.class);

        when(deal.getContact()).thenReturn(contact);
        when(deal.getVehicle()).thenReturn(vehicle);
        when(contact.getFirstName()).thenReturn("Jay");
        when(contact.getLastName()).thenReturn("Patel");
        when(contact.getEmail()).thenReturn("patel.jay@live.fr");
        when(deal.getPrice()).thenReturn(19000.00);
        when(deal.getReference()).thenReturn("B300053623");
        when(vehicle.getRegisterNumber()).thenReturn("AA123AA");

        Analysis analysis = scamDetectorService.analyze(deal);

        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(analysis));

        assertEquals("B300053623", analysis.getReference());
        assertTrue(analysis.isScam());
        assertEquals(2, analysis.getRules().size());
    }

    @Test
    void analyze_DealIsScam_False() {
        Deal deal = mock(Deal.class);
        Contact contact = mock(Contact.class);
        Vehicle vehicle = mock(Vehicle.class);

        when(deal.getContact()).thenReturn(contact);
        when(deal.getVehicle()).thenReturn(vehicle);
        when(contact.getFirstName()).thenReturn("Jay");
        when(contact.getLastName()).thenReturn("Patel");
        when(contact.getEmail()).thenReturn("patel.jay@live.fr");
        when(deal.getPrice()).thenReturn(28000.00);
        when(deal.getReference()).thenReturn("B300053623");
        when(vehicle.getRegisterNumber()).thenReturn("AA123AB");

        Analysis analysis = scamDetectorService.analyze(deal);

        assertEquals("B300053623", analysis.getReference());
        assertFalse(analysis.isScam());
        assertEquals(0, analysis.getRules().size());
    }

    @Test
    void analyze_DealIsScamWithDecisiveRules_False() {
        Deal deal = mock(Deal.class);
        Contact contact = mock(Contact.class);
        Vehicle vehicle = mock(Vehicle.class);

        when(deal.getContact()).thenReturn(contact);
        when(deal.getVehicle()).thenReturn(vehicle);
        when(contact.getFirstName()).thenReturn("Jay");
        when(contact.getLastName()).thenReturn("Patel");
        when(contact.getEmail()).thenReturn("patel.jay@live.fr");
        when(deal.getPrice()).thenReturn(19000.00);
        when(deal.getReference()).thenReturn("B300053623");
        when(vehicle.getRegisterNumber()).thenReturn("AA123AA");
        when(deal.getPublicationOptions()).thenReturn(Arrays.asList("STRENGTHS", "BOOST_VO"));

        Analysis analysis = scamDetectorService.analyze(deal);

        assertEquals("B300053623", analysis.getReference());
        assertFalse(analysis.isScam());
        assertEquals(3, analysis.getRules().size());
    }
}
