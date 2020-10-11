package com.gildedrose;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    Item[] items;

    @Nested
    class _通常商品の場合 {
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
        void _更新するとsellIn値が1減る() {
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(19, app.items[0].sellIn);
        }

        @Test
        void _更新するとquality値の更新が1減る() {
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(29, app.items[0].quality);
        }
    }
    
    @Nested
    class _Sulfurasの場合 {
        @BeforeEach
        void _準備() {
            items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 20, 30) };
        }
        
        @Test
        void _Item名がSulfurasの場合更新してもItem名が変わらない() {
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        }

        @Test
        void _Item名がSulfurasの場合更新してもSellIn値が変わらない() {
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(20, app.items[0].sellIn);
        }

        @Test
        void _Item名がSulfurasの場合更新してもQuality値が変わらない() {
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(30, app.items[0].quality);
        }   
    }

}
