package com.amaysim.rule;

import com.amaysim.CartItem;
import com.amaysim.Item;

/**
 * Created by aiam on 5/6/2017.
 */
public class BundleChargePromoRuleEngine extends AbstractRuleEngine {
    public Item bundleItem;

    public BundleChargePromoRuleEngine(String ruleName, Item item, Item bundleItem) {
        this.ruleName = ruleName;
        this.item = item;
        this.bundleItem = bundleItem;
    }

    @Override
    public CartItem processCartItems(CartItem item) {
        return item;
    }

    protected CartItem getFreeItem(CartItem item) {
        CartItem ci = new CartItem();
        ci.item = bundleItem;
        ci.item.promoAmount = 0;
        ci.count = item.count;
        return ci;
    }
}
