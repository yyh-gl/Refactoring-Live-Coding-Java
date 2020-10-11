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
    void _Item名の更新() {
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void _sellIn値の更新() {
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(19, app.items[0].sellIn);
    }

    @Test
    void _quality値の更新() {
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(29, app.items[0].quality);
    }

}
