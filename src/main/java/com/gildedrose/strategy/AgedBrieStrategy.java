package com.gildedrose.strategy;

import com.gildedrose.Item;

public class AgedBrieStrategy extends DefaultStrategy {
    @Override
    public void updateItem(Item item) {
        if (item.sellIn > 0) {
            item.quality += 1;
        } else {
            item.quality += 2;
        }
        this.reduceSellInAndCheckMaxAndMinQuality(item);
    }
}
