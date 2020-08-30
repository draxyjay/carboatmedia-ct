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

public class FirstNameLengthRuleTest {

    @Test
    void firstNameLengthRule_LengthLongerThan2_True() {
        Deal deal = mock(Deal.class);
        Contact contact = mock(Contact.class);

        when(deal.getContact()).thenReturn(contact);
        when(contact.getFirstName()).thenReturn("Jay");

        Facts facts = new Facts();
        facts.put("firstName", deal);

        Rule rule = RuleProxy.asRule(new FirstNameLengthRule());
        boolean isFirstNameLongerThanTwo = rule.evaluate(facts);

        assertTrue(isFirstNameLongerThanTwo);
    }

    @Test
    void firstNameLengthRule_LengthLongerThan2_False() {
        Deal deal = mock(Deal.class);
        Contact contact = mock(Contact.class);

        when(deal.getContact()).thenReturn(contact);
        when(contact.getFirstName()).thenReturn("J");

        Facts facts = new Facts();
        facts.put("firstName", deal);

        Rule rule = RuleProxy.asRule(new FirstNameLengthRule());
        boolean isFirstNameLongerThanTwo = rule.evaluate(facts);

        assertFalse(isFirstNameLongerThanTwo);
    }
}
