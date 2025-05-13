package com.gildedrose;

import com.gildedrose.strategy.StrategyService;

class GildedRose {
    final Item[] items;
    final StrategyService strategyService;

    public GildedRose(Item[] items) {
        this.items = items;
        this.strategyService = new StrategyService();
    }

    public void updateQuality() {
        for (Item item : items) {
            var strategy = strategyService.generateStrategy(item);

            strategy.updateItem(item);
        }
    }

}
