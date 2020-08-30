package fr.carboatmedia.scamdetector.rules;

import fr.carboatmedia.scamdetector.models.Deal;
import fr.carboatmedia.scamdetector.services.BlacklistService;
import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

@Rule(
        name = "rule::registernumber::blacklist",
        description = "If a register number is not blacklisted"
)
public class RegisterNumberBlacklistRule {

    @Condition
    public boolean isRegisterNumberNotBlacklisted(@Fact("registerNumberBlacklist") Deal deal) {
        return !BlacklistService.isBlacklisted(deal.getVehicle().getRegisterNumber());
    }

    @Action
    public void ignore() {
    }
}
