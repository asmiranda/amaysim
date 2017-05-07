package com.amaysim;

import com.amaysim.rule.AbstractAccrossRuleEngine;
import com.amaysim.rule.AbstractRuleEngine;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aiam on 5/6/2017.
 */
public class ShoppingCart {
    List<AbstractRuleEngine> rules = new ArrayList();
    List<CartItem> items = new ArrayList();

    List<PromoItem> runningPromoItems = new ArrayList();
    double runningTotal = 0;

    public static ShoppingCart newCart(List<AbstractRuleEngine> rules) {
        ShoppingCart s = new ShoppingCart();
        s.rules = rules;
        return s;
    }

    public CartItem add(Item item, int count) {
        CartItem ci = add(item, count, null);
        return ci;
    }

    public CartItem add(Item item, int count, String promoCode) {
        CartItem ci = new CartItem();
        ci.item = item;
        ci.count = count;
        ci.promoCode = promoCode;
        items.add(ci);
        processRunningTotals(ci, promoCode);
        return ci;
    }

    private void processRunningTotals(CartItem item, String promoCode) {
        PromoItem promo = AbstractRuleEngine.applyRules(item, rules);
        runningPromoItems.add(promo);
        runningTotal += promo.amount;
        if (promoCode != null) {
            runningTotal = AbstractAccrossRuleEngine.applyAccrossRules(promoCode, runningTotal, rules);
        }
    }

    public double total() {
        return runningTotal;
    }

    public List<CartItem> items() {
        List<CartItem> items = new ArrayList();
        for (PromoItem p:runningPromoItems) {
            items.add(p.item);
            if (p.promoItem != null) {
                items.add(p.promoItem);
            }
        }
        return items;
    }

    public List<CartItem> freeItem() {
        List<CartItem> items = new ArrayList();
        for (PromoItem p:runningPromoItems) {
            if (p.freeItem != null) {
                items.add(p.freeItem);
            }
        }
        return items;
    }
}
