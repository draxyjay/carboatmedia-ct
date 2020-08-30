package fr.carboatmedia.scamdetector.rules;

import fr.carboatmedia.scamdetector.models.Deal;
import fr.carboatmedia.scamdetector.models.Vehicle;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rule;
import org.jeasy.rules.core.RuleProxy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RegisterNumberBlacklistRuleTest {

    @Test
    void registerNumberBlacklist_isRegisterNumberNotBlacklisted_True() {
        Deal deal = mock(Deal.class);
        Vehicle vehicle = mock(Vehicle.class);

        when(deal.getVehicle()).thenReturn(vehicle);
        when(vehicle.getRegisterNumber()).thenReturn("AA123AB");

        Facts facts = new Facts();
        facts.put("registerNumberBlacklist", deal);

        Rule rule = RuleProxy.asRule(new RegisterNumberBlacklistRule());
        boolean isRegisterNumberBlacklisted = rule.evaluate(facts);

        assertTrue(isRegisterNumberBlacklisted);
    }

    @Test
    void registerNumberBlacklist_isRegisterNumberNotBlacklisted_False() {
        Deal deal = mock(Deal.class);
        Vehicle vehicle = mock(Vehicle.class);

        when(deal.getVehicle()).thenReturn(vehicle);
        when(vehicle.getRegisterNumber()).thenReturn("AA123AA");

        Facts facts = new Facts();
        facts.put("registerNumberBlacklist", deal);

        Rule rule = RuleProxy.asRule(new RegisterNumberBlacklistRule());
        boolean isRegisterNumberBlacklisted = rule.evaluate(facts);

        assertFalse(isRegisterNumberBlacklisted);
    }
}
