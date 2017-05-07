package com.amaysim.rule;

import com.amaysim.CartItem;
import com.amaysim.Item;
import com.amaysim.PromoItem;

import java.util.List;

/**
 * Created by aiam on 5/6/2017.
 */
public abstract class AbstractRuleEngine {
    public String ruleName;
    public Item item;

    public String promoCode;
    public double discountPercentage;

    public Item getRuleItem() {
        return item;
    }

    public abstract CartItem processCartItems(CartItem item);

    public static PromoItem applyRules(CartItem item, List<AbstractRuleEngine> rules) {
        AbstractRuleEngine useRule = getRuleToApply(item, rules);
        PromoItem promo = new PromoItem();
        promo.item = item;
        if (useRule != null) {
            CartItem promoItem = useRule.processCartItems(item);
            promo.freeItem = useRule.getFreeItem(item);
            promo.promoItem = promoItem;
            promo.amount = calculateAmount(promo);
        }
        else {
            promo.freeItem = null;
            promo.promoItem = null;
            promo.amount = calculateAmount(promo);
        }
        return promo;
    }

    protected CartItem getFreeItem(CartItem item) {
        return null;
    }

    private static double calculateAmount(PromoItem promo) {
        double d = 0;
        CartItem toCalculate = promo.promoItem;
        if (toCalculate == null) {
            toCalculate = promo.item;
        }
        for (int i=0; i<toCalculate.count; i++) {
            double amount = toCalculate.item.promoAmount;
            d += amount;
        }
        return d;
    }

    protected static AbstractRuleEngine getRuleToApply(CartItem item, List<AbstractRuleEngine> rules) {
        AbstractRuleEngine rule = null;
        for (AbstractRuleEngine r:rules) {
            if (!(r instanceof AbstractAccrossRuleEngine) && r.getRuleItem().equals(item.item)) {
                rule = r;
                break;
            }
        }
        return rule;
    }
}
