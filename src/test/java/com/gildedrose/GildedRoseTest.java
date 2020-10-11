package com.gildedrose;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    Item[] items;
    
    @BeforeEach
    void _準備() {
         items = new Item[] { new Item("foo", 20, 30) };
    }
    

    @Test
    void _更新してもItem名が変わらない() {
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void 更新すると_sellIn値が1減る() {
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(19, app.items[0].sellIn);
    }

    @Test
    void 更新すると_quality値の更新が1減る() {
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(29, app.items[0].quality);
    }
    
    @Test
    void _Item名が_Sulfurasの場合更新してもItem名が変わらない() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 20, 30)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
    }

    @Test
    void _Item名が_Sulfurasの場合更新してもSellIn値が変わらない() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 20, 30)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(20, app.items[0].sellIn);
    }

    @Test
    void _Item名が_Sulfurasの場合更新してもQuality値が変わらない() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 20, 30)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(30, app.items[0].quality);
    }

}
