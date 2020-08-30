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

public class LastNameLengthRuleTest {

    @Test
    void lastNameLengthRule_LengthLongerThan2_True() {
        Deal deal = mock(Deal.class);
        Contact contact = mock(Contact.class);

        when(deal.getContact()).thenReturn(contact);
        when(contact.getLastName()).thenReturn("Patel");

        Facts facts = new Facts();
        facts.put("lastName", deal);

        Rule rule = RuleProxy.asRule(new LastNameLengthRule());
        boolean isLastNameLongerThanTwo = rule.evaluate(facts);

        assertTrue(isLastNameLongerThanTwo);
    }

    @Test
    void lastNameLengthRule_LengthLongerThan2_False() {
        Deal deal = mock(Deal.class);
        Contact contact = mock(Contact.class);

        when(deal.getContact()).thenReturn(contact);
        when(contact.getLastName()).thenReturn("P");

        Facts facts = new Facts();
        facts.put("lastName", deal);

        Rule rule = RuleProxy.asRule(new LastNameLengthRule());
        boolean isFirstNameLongerThanTwo = rule.evaluate(facts);

        assertFalse(isFirstNameLongerThanTwo);
    }
}
