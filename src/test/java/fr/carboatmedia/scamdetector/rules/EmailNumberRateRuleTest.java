package fr.carboatmedia.scamdetector.rules;

import fr.carboatmedia.scamdetector.models.Contact;
import fr.carboatmedia.scamdetector.models.Deal;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rule;
import org.jeasy.rules.core.RuleProxy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EmailNumberRateRuleTest {

    @Test
    void emailAlphaRateRule_NumberRateGreaterThanLimit_True() {
        Deal deal = mock(Deal.class);
        Contact contact = mock(Contact.class);

        when(deal.getContact()).thenReturn(contact);
        when(contact.getEmail()).thenReturn("patel.jay1@live.fr");

        Facts facts = new Facts();
        facts.put("emailNumberRate", deal);

        Rule rule = RuleProxy.asRule(new EmailNumberRateRule());
        boolean isEmailNumberRateGreater = rule.evaluate(facts);

        assertTrue(isEmailNumberRateGreater);
    }

    @Test
    void emailAlphaRateRule_NumberRateGreaterThanLimit_False() {
        Deal deal = mock(Deal.class);
        Contact contact = mock(Contact.class);

        when(deal.getContact()).thenReturn(contact);
        when(contact.getEmail()).thenReturn("p123@live.fr");

        Facts facts = new Facts();
        facts.put("emailNumberRate", deal);

        Rule rule = RuleProxy.asRule(new EmailNumberRateRule());
        boolean isEmailNumberRateGreater = rule.evaluate(facts);

        assertFalse(isEmailNumberRateGreater);
    }
}
