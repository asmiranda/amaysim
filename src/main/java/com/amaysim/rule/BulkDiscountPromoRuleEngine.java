package com.amaysim.rule;

import com.amaysim.CartItem;
import com.amaysim.Item;

/**
 * Created by aiam on 5/6/2017.
 */
public class BulkDiscountPromoRuleEngine extends AbstractRuleEngine {
    public int minOrderItemCount;
    public double promoPriceDrop;

    public BulkDiscountPromoRuleEngine(String ruleName, Item item, int minOrderItemCount, double promoPriceDrop) {
        this.ruleName = ruleName;
        this.item = item;
        this.minOrderItemCount = minOrderItemCount;
        this.promoPriceDrop = promoPriceDrop;
    }

    @Override
    public CartItem processCartItems(CartItem item) {
        if (item.count >= minOrderItemCount) {
            item.item.promoAmount = promoPriceDrop;
        }
        return item;
    }
}
