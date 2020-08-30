package fr.carboatmedia.scamdetector.rules;

import fr.carboatmedia.scamdetector.models.Deal;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rule;
import org.jeasy.rules.core.RuleProxy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PriceQuotationRateRuleTest {

    @Test
    void priceQuotationRateRule_isInRangeOf20_True() {
        Deal deal = mock(Deal.class);

        when(deal.getPrice()).thenReturn(38000.00);

        Facts facts = new Facts();
        facts.put("quotationRate", deal);

        Rule rule = RuleProxy.asRule(new PriceQuotationRateRule());
        boolean isPriceQuotationRateInRange = rule.evaluate(facts);

        assertTrue(isPriceQuotationRateInRange);
    }

    @Test
    void priceQuotationRateRule_isInRangeOf20_False() {
        Deal deal = mock(Deal.class);

        when(deal.getPrice()).thenReturn(19000.00);

        Facts facts = new Facts();
        facts.put("quotationRate", deal);

        Rule rule = RuleProxy.asRule(new PriceQuotationRateRule());
        boolean isPriceQuotationRateInRange = rule.evaluate(facts);

        assertFalse(isPriceQuotationRateInRange);
    }
}
