package com.amaysim.rule;

import com.amaysim.CartItem;

import java.util.List;

/**
 * Created by aiam on 5/7/2017.
 */
public abstract class AbstractAccrossRuleEngine extends AbstractRuleEngine {

    @Override
    public final CartItem processCartItems(CartItem item) {
        return null;
    }

    public abstract double processTotal(double runningTotal);

    public static double applyAccrossRules(String promoCode, double runningTotal, List<AbstractRuleEngine> rules) {
        double total = runningTotal;
        AbstractRuleEngine rule = null;
        for (AbstractRuleEngine r:rules) {
            if (r instanceof AbstractAccrossRuleEngine && promoCode.equals(r.promoCode)) {
                rule = r;
                break;
            }
        }
        if (rule != null) {
            total = ((AbstractAccrossRuleEngine)rule).processTotal(runningTotal);
        }
        return total;
    }
}
