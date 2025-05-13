package com.gildedrose.strategy;

import com.gildedrose.Item;

public class StrategyService {

    private static final String AGED_BRIE_NAME = "Aged Brie";
    private static final String CONJURED_NAME = "Conjured";
    private static final String LEGENDARY_NAME = "Sulfuras, Hand of Ragnaros";
    private static final String BACKSTAGE_PASSES_NAME = "Backstage passes to a";

    public Strategy generateStrategy(Item item) {
            switch (item.name) {
                case String s when s.startsWith(CONJURED_NAME) -> {
                    return new ConjuredStrategy();
                }
                case String s when s.startsWith(BACKSTAGE_PASSES_NAME) -> {
                    return new BackstagePassesStrategy();
                }
                case LEGENDARY_NAME  -> {
                    return new LegendaryStrategy();
                }
                case AGED_BRIE_NAME -> {
                    return new AgedBrieStrategy();
                }
                default -> {
                    return new DefaultStrategy();
                }
            }
    }

}
