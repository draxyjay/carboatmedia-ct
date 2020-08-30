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

public class EmailAlphaRateRuleTest {

    @Test
    void emailAlphaRateRule_AlphaRateGreaterThan70_True() {
        Deal deal = mock(Deal.class);
        Contact contact = mock(Contact.class);

        when(deal.getContact()).thenReturn(contact);
        when(contact.getEmail()).thenReturn("patel.jay@live.fr");

        Facts facts = new Facts();
        facts.put("emailAlphaRate", deal);

        Rule rule = RuleProxy.asRule(new EmailAlphaRateRule());
        boolean isEmailAlphaRateGreater = rule.evaluate(facts);

        assertTrue(isEmailAlphaRateGreater);
    }

    @Test
    void emailAlphaRateRule_AlphaRateGreaterThan70_False() {
        Deal deal = mock(Deal.class);
        Contact contact = mock(Contact.class);

        when(deal.getContact()).thenReturn(contact);
        when(contact.getEmail()).thenReturn("p.t.l.@live.fr");

        Facts facts = new Facts();
        facts.put("emailAlphaRate", deal);

        Rule rule = RuleProxy.asRule(new EmailAlphaRateRule());
        boolean isEmailAlphaRateGreater = rule.evaluate(facts);

        assertFalse(isEmailAlphaRateGreater);
    }
}
