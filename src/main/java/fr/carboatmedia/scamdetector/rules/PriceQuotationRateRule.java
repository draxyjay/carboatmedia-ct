package fr.carboatmedia.scamdetector.rules;

import fr.carboatmedia.scamdetector.models.Deal;
import fr.carboatmedia.scamdetector.services.QuotationService;
import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

@Rule(
        name = "rule::price::quotation_rate",
        description = "Price of deal should be in range of 20% of the quotation rate"
)
public class PriceQuotationRateRule {

    private static final double RATIO = 0.2;

    @Condition
    public boolean isInRangeOfRatio(@Fact("quotationRate") Deal deal) {
        double rate = QuotationService.computeRate(deal.getVehicle());

        return deal.getPrice() >= (1 - RATIO) * rate && deal.getPrice() <= (1 + RATIO) * rate;
    }

    @Action
    public void ignore() {
    }
}
