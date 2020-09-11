package fr.carboatmedia.scamdetector.rules;

import fr.carboatmedia.scamdetector.models.Deal;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rule;
import org.jeasy.rules.core.RuleProxy;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PublicationOptionsRuleTest {

    @Test
    void publicationOption_IsValid_True() {
        Deal deal = mock(Deal.class);

        when(deal.getPublicationOptions()).thenReturn(Arrays.asList("STRENGTHS", "BOOST_VO"));

        Facts facts = new Facts();
        facts.put("publicationOption", deal);

        Rule rule = RuleProxy.asRule(new PublicationOptionsRule());
        boolean isPublicationOptionRuleIsValid = rule.evaluate(facts);

        assertTrue(isPublicationOptionRuleIsValid);
    }

    @Test
    void publicationOption_IsValid_False() {
        Deal deal = mock(Deal.class);

        when(deal.getPublicationOptions()).thenReturn(Collections.singletonList("NOT_VALID"));

        Facts facts = new Facts();
        facts.put("publicationOption", deal);

        Rule rule = RuleProxy.asRule(new PublicationOptionsRule());
        boolean isPublicationOptionRuleIsValid = rule.evaluate(facts);

        assertFalse(isPublicationOptionRuleIsValid);
    }
}
