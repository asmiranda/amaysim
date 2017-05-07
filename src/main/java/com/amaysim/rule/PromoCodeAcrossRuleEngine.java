package com.amaysim.rule;

/**
 * Created by aiam on 5/6/2017.
 */
public class PromoCodeAcrossRuleEngine extends AbstractAccrossRuleEngine {
    public PromoCodeAcrossRuleEngine(String promoCode, double discountPercentage) {
        this.promoCode = promoCode;
        this.discountPercentage = discountPercentage;
    }

    @Override
    public double processTotal(double runningTotal) {
        return runningTotal * (1-discountPercentage/100);
    }
}
