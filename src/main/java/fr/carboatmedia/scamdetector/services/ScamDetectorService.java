package fr.carboatmedia.scamdetector.services;

import fr.carboatmedia.scamdetector.models.Analysis;
import fr.carboatmedia.scamdetector.models.Deal;
import fr.carboatmedia.scamdetector.rules.*;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rule;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;

import java.util.Map;

public class ScamDetectorService {

    public Analysis analyze(Deal deal) {
        Analysis analysis = new Analysis();

        analysis.setReference(deal.getReference());

        Facts facts = new Facts();
        facts.put("firstName", deal);
        facts.put("lastName", deal);
        facts.put("emailAlphaRate", deal);
        facts.put("emailNumberRate", deal);
        facts.put("quotationRate", deal);
        facts.put("registerNumberBlacklist", deal);
        facts.put("publicationOption", deal);

        Rules rules = new Rules(), decisiveRules = new Rules();

        // Normal rules
        rules.register(new FirstNameLengthRule());
        rules.register(new LastNameLengthRule());
        rules.register(new EmailAlphaRateRule());
        rules.register(new EmailNumberRateRule());
        rules.register(new PriceQuotationRateRule());
        rules.register(new RegisterNumberBlacklistRule());

        // Decisive rules with high priority
        decisiveRules.register(new PublicationOptionsRule());

        RulesEngine rulesEngine = new DefaultRulesEngine();
        Map<Rule, Boolean> checkedRules = rulesEngine.check(rules, facts);
        Map<Rule, Boolean> checkedDecisiveRules = rulesEngine.check(decisiveRules, facts);

        checkedRules.forEach((rule, isValid) -> {
            if (!isValid) {
                analysis.setScam(true);
                analysis.addRule(rule.getName());
            }
        });

        checkedDecisiveRules.forEach((rule, isValid) -> {
            if (isValid) {
                analysis.setScam(false);
                analysis.addRule(rule.getName());
            }
        });

        return analysis;
    }
}
