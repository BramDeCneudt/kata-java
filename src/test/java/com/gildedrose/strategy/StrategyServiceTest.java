package com.gildedrose.strategy;

import com.gildedrose.external.Item;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class StrategyServiceTest {

    private final StrategyService strategyService = new StrategyService();

    @ParameterizedTest
    @CsvSource({
        "Normal Item, DefaultStrategy",
        "Aged Brie, AgedBrieStrategy",
        "'Sulfuras, Hand of Ragnaros', LegendaryStrategy",
        "Backstage passes to a TAFKAL80ETC concert, BackstagePassesStrategy",
        "Conjured Mana Cake, ConjuredStrategy",
    })
    void Given_AnItem_When_TriggeringGenerateStrategy_Then_GenerateStrategyShouldReturnCorrectStrategy(String itemName, String simpleClassName) {
        Item item = new Item(itemName, 5, 20);

        var strategy = strategyService.generateStrategy(item);

        assertEquals(simpleClassName, strategy.getClass().getSimpleName());
    }
}
