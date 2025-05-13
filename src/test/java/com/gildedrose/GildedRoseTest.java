package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void Given_AnItemWithPositiveSellIn_When_UpdateInQualityIsTriggered_Then_QualityShouldDegradeNormally() {
        String itemName = "Normal Item";
        Item[] items = new Item[] { new Item(itemName, 5, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(itemName, app.items[0].name);
        assertEquals(19, app.items[0].quality);
        assertEquals(4, app.items[0].sellIn);
    }

    @Test
    void Given_AnItemWithAlmostPositiveSellIn_When_UpdateInQualityIsTriggered_Then_QualityShouldDegradeNormally() {
        String itemName = "Normal Item";
        Item[] items = new Item[] { new Item(itemName, 1, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(itemName, app.items[0].name);
        assertEquals(19, app.items[0].quality);
        assertEquals(0, app.items[0].sellIn);
    }

    @Test
    void Given_AnItemWithZeroSellIn_When_UpdateInQualityIsTriggered_Then_QualityShouldDegradeTwiceAsFast() {
        String itemName = "Degraded Item";
        Item[] items = new Item[] { new Item(itemName, 0, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(itemName, app.items[0].name);
        assertEquals(18, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }


    @Test
    void Given_AnItemWithZeroQualityButPositiveSellIn_When_UpdateInQualityIsTriggered_Then_QualityShouldRemainAtZero() {
        String itemName = "Zero Quality Item";
        Item[] items = new Item[] { new Item(itemName, 5, 0) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(itemName, app.items[0].name);
        assertEquals(0, app.items[0].quality);
        assertEquals(4, app.items[0].sellIn);
    }

    @Test
    void Given_AnItemWithZeroQualityAndNegativeSellIn_When_UpdateInQualityIsTriggered_Then_QualityShouldRemainAtZero() {
        String itemName = "Zero Degraded Quality Item";
        Item[] items = new Item[] { new Item(itemName, -5, 0) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(itemName, app.items[0].name);
        assertEquals(0, app.items[0].quality);
        assertEquals(-6, app.items[0].sellIn);
    }

    @Test
    void Given_AnAgedBrieItem_When_UpdateInQualityIsTriggered_Then_QualityShouldIncrease() {
        String itemName = "Aged Brie";
        Item[] items = new Item[] { new Item(itemName, 5, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(itemName, app.items[0].name);
        assertEquals(21, app.items[0].quality);
        assertEquals(4, app.items[0].sellIn);
    }

    @Test
    void Given_AnAgedBrieItemWithNegativeSellIn_When_UpdateInQualityIsTriggered_Then_QualityShouldIncreaseBy2() {
        String itemName = "Aged Brie";
        Item[] items = new Item[] { new Item(itemName, -5, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(itemName, app.items[0].name);
        assertEquals(22, app.items[0].quality);
        assertEquals(-6, app.items[0].sellIn);
    }


    @Test
    void Given_AnAgedBrieMaximumQuality_When_UpdateInQualityIsTriggered_Then_QualityShouldRemainTheSame() {
        String itemName = "Aged Brie";
        Item[] items = new Item[] { new Item(itemName, 5, 50) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(itemName, app.items[0].name);
        assertEquals(50, app.items[0].quality);
        assertEquals(4, app.items[0].sellIn);
    }

    @Test
    void Given_AnLegendaryItemWithInvalidQuality_When_UpdateInQualityIsTriggered_Then_QualityShouldBeValidAgain() {
        String itemName = "Sulfuras, Hand of Ragnaros";
        Item[] items = new Item[] { new Item(itemName, 4, 75) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(itemName, app.items[0].name);
        assertEquals(80, app.items[0].quality);
        assertEquals(4, app.items[0].sellIn);
    }

    @Test
    void Given_AnLegendaryItem_When_UpdateInQualityIsTriggered_Then_QualityShouldRemainTheSame() {
        String itemName = "Sulfuras, Hand of Ragnaros";
        Item[] items = new Item[] { new Item(itemName, 4, 80) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(itemName, app.items[0].name);
        assertEquals(80, app.items[0].quality);
        assertEquals(4, app.items[0].sellIn);
    }

    @Test
    void Given_AnLegendaryItemWithZeroSellIn_When_UpdateInQualityIsTriggered_Then_QualityAndSellInShouldRemainTheSame() {
        String itemName = "Sulfuras, Hand of Ragnaros";
        Item[] items = new Item[] { new Item(itemName, 0, 80) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(itemName, app.items[0].name);
        assertEquals(80, app.items[0].quality);
        assertEquals(0, app.items[0].sellIn);
    }

    @Test
    void Given_BackstagePassesWithMoreThen10SellIn_When_UpdateInQualityIsTriggered_Then_QualityShouldIncrease() {
        String itemName = "Backstage passes to a TAFKAL80ETC concert";
        Item[] items = new Item[] { new Item(itemName, 15, 40) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(itemName, app.items[0].name);
        assertEquals(41, app.items[0].quality);
        assertEquals(14, app.items[0].sellIn);
    }

    @Test
    void Given_BackstagePassesWith10SellIn_When_UpdateInQualityIsTriggered_Then_QualityShouldIncreaseBy2() {
        String itemName = "Backstage passes to a TAFKAL80ETC concert";
        Item[] items = new Item[] { new Item(itemName, 10, 40) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(itemName, app.items[0].name);
        assertEquals(42, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);
    }

    @Test
    void Given_BackstagePassesWith5SellIn_When_UpdateInQualityIsTriggered_Then_QualityShouldIncreaseBy3() {
        String itemName = "Backstage passes to a TAFKAL80ETC concert";
        Item[] items = new Item[] { new Item(itemName, 5, 40) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(itemName, app.items[0].name);
        assertEquals(43, app.items[0].quality);
        assertEquals(4, app.items[0].sellIn);
    }

    @Test
    void Given_BackstagePassesWith5SellInButAlmostMaximumQuality_When_UpdateInQualityIsTriggered_Then_QualityShouldIncreaseBy2ToMaximumQuality() {
        String itemName = "Backstage passes to a TAFKAL80ETC concert";
        Item[] items = new Item[] { new Item(itemName, 5, 48) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(itemName, app.items[0].name);
        assertEquals(50, app.items[0].quality);
        assertEquals(4, app.items[0].sellIn);
    }

    @Test
    void Given_BackstagePassesWithSellIn0_When_UpdateInQualityIsTriggered_Then_QualityShouldDropTo0() {
        String itemName = "Backstage passes to a TAFKAL80ETC concert";
        // TODO kata-5 is this correct? Should drop to 0 already at day 0?
        Item[] items = new Item[] { new Item(itemName, -1, 50) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(itemName, app.items[0].name);
        assertEquals(0, app.items[0].quality);
        assertEquals(-2, app.items[0].sellIn);
    }


    @Test
    void Given_ConjuredItemsWithPositiveSellIn_When_UpdateInQualityIsTriggered_Then_QualityShouldDecreaseBy2() {
        String itemName = "Conjured item";

        Item[] items = new Item[] { new Item(itemName, 5, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(itemName, app.items[0].name);
        assertEquals(18, app.items[0].quality);
        assertEquals(4, app.items[0].sellIn);
    }


    @Test
    void Given_ConjuredItemsWithSellIn0_When_UpdateInQualityIsTriggered_Then_QualityShouldDecreaseBy4() {
        String itemName = "Conjured item";

        Item[] items = new Item[] { new Item(itemName, 0, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(itemName, app.items[0].name);
        assertEquals(16, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    void Given_ConjuredItemsWithNegativeSellIn_When_UpdateInQualityIsTriggered_Then_QualityShouldDecreaseBy4() {
        String itemName = "Conjured item";

        Item[] items = new Item[] { new Item(itemName, -5, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(itemName, app.items[0].name);
        assertEquals(16, app.items[0].quality);
        assertEquals(-6, app.items[0].sellIn);
    }



}
