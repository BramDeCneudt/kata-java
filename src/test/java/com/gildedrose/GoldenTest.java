package com.gildedrose;

import com.gildedrose.external.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GoldenTest {

    String goldenResult = """
-------- day 0 --------
name, sellIn, quality
+5 Dexterity Vest, 10, 0
+6 Dexterity Vest, -1, 10
Aged Brie, 2, 0
Aged Brie, 2, 50
Elixir of the Mongoose, 5, 7
Sulfuras, Hand of Ragnaros, 0, 80
Sulfuras, Hand of Ragnaros, -1, 80
Backstage passes to a TAFKAL80ETC concert, 15, 50
Backstage passes to a TAFKAL80ETC concert, 15, 20
Backstage passes to a TAFKAL80ETC concert, 10, 50
Backstage passes to a TAFKAL80ETC concert, 10, 20
Backstage passes to a TAFKAL80ETC concert, 5, 20
Backstage passes to a TAFKAL80ETC concert, 5, 50
Backstage passes to a TAFKAL80ETC concert, 0, 49
Conjured Mana Cake, 3, 6
Conjured Mana Cake, -3, 6
Conjured Mana Cake, -3, 3

-------- day 1 --------
name, sellIn, quality
+5 Dexterity Vest, 9, 0
+6 Dexterity Vest, -2, 8
Aged Brie, 1, 1
Aged Brie, 1, 50
Elixir of the Mongoose, 4, 6
Sulfuras, Hand of Ragnaros, 0, 80
Sulfuras, Hand of Ragnaros, -1, 80
Backstage passes to a TAFKAL80ETC concert, 14, 50
Backstage passes to a TAFKAL80ETC concert, 14, 21
Backstage passes to a TAFKAL80ETC concert, 9, 50
Backstage passes to a TAFKAL80ETC concert, 9, 22
Backstage passes to a TAFKAL80ETC concert, 4, 23
Backstage passes to a TAFKAL80ETC concert, 4, 50
Backstage passes to a TAFKAL80ETC concert, -1, 0
Conjured Mana Cake, 2, 4
Conjured Mana Cake, -4, 2
Conjured Mana Cake, -4, 0

    """;

    @Test
    public void goldenTest() {
        Item[] items = new Item[]{
            new Item("+5 Dexterity Vest", 10, 0), //
            new Item("+6 Dexterity Vest", -1, 10), //
            new Item("Aged Brie", 2, 0), //
            new Item("Aged Brie", 2, 50), //
            new Item("Elixir of the Mongoose", 5, 7), //
            new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
            new Item("Sulfuras, Hand of Ragnaros", -1, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 50),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 50),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 50),
            new Item("Backstage passes to a TAFKAL80ETC concert", 0, 49),
            new Item("Conjured Mana Cake", 3, 6),
            new Item("Conjured Mana Cake", -3, 6),
            new Item("Conjured Mana Cake", -3, 3)
        };

        GildedRose app = new GildedRose(items);

        int days = 2;

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < days; i++) {
            stringBuilder.append(String.format("-------- day %d --------\n", i));
            stringBuilder.append("name, sellIn, quality\n");
            for (Item item : items) {
                stringBuilder.append(item);
                stringBuilder.append("\n");
            }
            stringBuilder.append("\n");
            app.updateQuality();
        }
        System.out.println(stringBuilder);

        Assertions.assertEquals(goldenResult, stringBuilder.toString());

    }

}
