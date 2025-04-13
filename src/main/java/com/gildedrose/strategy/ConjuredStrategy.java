package com.gildedrose.strategy;

import com.gildedrose.external.Item;

public class ConjuredStrategy extends DefaultStrategy {

    protected final int maxQualityStandardItem = 50;
    protected final int minQualityStandardItem = 0;

    @Override
    public void updateItem(Item item) {
        if (item.sellIn > 0) {
            item.quality -= 2;
        } else {
            item.quality -= 4;
        }
        this.reduceSellInAndCheckMaxAndMinQuality(item);
    }

}
