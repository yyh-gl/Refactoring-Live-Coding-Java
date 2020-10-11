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
        void _更新するとquality値が1減る() {
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(29, app.items[0].quality);
        }

        @Test
        void _SellIn値が1の場合更新するとquality値が1減る() {
            items = new Item[] { new Item("foo", 1, 30) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(29, app.items[0].quality);
        }

        @Test
        void _SellIn値が0の場合更新するとquality値が2減る() {
            items = new Item[] { new Item("foo", 0, 30) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(28, app.items[0].quality);
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

    @Nested
    class _AgedBrieの場合 {
        @BeforeEach
        void _準備() {
            items = new Item[] { new Item("Aged Brie", 20, 30) };
        }

        @Test
        void _Item名がAgedBrieの場合更新してもItem名が変わらない() {
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals("Aged Brie", app.items[0].name);
        }

        @Test
        void _Item名がAgedBrieの場合更新してもSellIn値が1減る() {
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(19, app.items[0].sellIn);
        }

        @Test
        void _Item名がAgedBrieの場合更新してもQuality値が1増える() {
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(31, app.items[0].quality);
        }

        @Test
        void _Item名がAgedBrieでQuality値が49の場合更新するとQuality値が1増える() {
            items = new Item[] { new Item("Aged Brie", 20, 49) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(50, app.items[0].quality);
        }

        @Test
        void _Item名がAgedBrieでQuality値が50の場合更新してもQuality値が変わらない() {
            items = new Item[] { new Item("Aged Brie", 20, 49) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(50, app.items[0].quality);
        }

        @Test
        void _Item名がAgedBrieでSellIn値が0の場合更新するとQuality値は2増える() {
            items = new Item[] { new Item("Aged Brie", 0, 30) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(32, app.items[0].quality);
        }

        @Test
        void _Item名がAgedBrieでSellIn値が1の場合更新するとQuality値は1増える() {
            items = new Item[] { new Item("Aged Brie", 1, 30) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(31, app.items[0].quality);
        }
    }

    @Nested
    class _BackstagePassesの場合 {
        @BeforeEach
        void _準備() {
            items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 20, 30) };
        }

        @Test
        void _Item名がBackstagePassesの場合更新してもItem名が変わらない() {
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        }

        @Test
        void _Item名がBackstagePassesの場合更新するとSellIn値が1減る() {
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(19, app.items[0].sellIn);
        }

        @Test
        void _Item名がBackstagePassesの場合更新するとQuality値が1増える() {
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(31, app.items[0].quality);
        }

        @Test
        void _Item名がBackstagePassesでQuality値が49の場合更新するとQuality値が1増える() {
            items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 20, 49) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(50, app.items[0].quality);
        }

        @Test
        void _Item名がBackstagePassesでQuality値が50の場合更新してもQuality値が変わらない() {
            items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 20, 49) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(50, app.items[0].quality);
        }

        @Test
        void _Item名がBackstagePassesでSellIn値が11の場合更新するとQuality値は1増える() {
            items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 11, 30) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(31, app.items[0].quality);
        }

        @Test
        void _Item名がBackstagePassesでSellIn値が10の場合更新するとQuality値は2増える() {
            items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 30) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(32, app.items[0].quality);
        }

        @Test
        void _Item名がBackstagePassesでSellIn値が6の場合更新するとQuality値は2増える() {
            items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 6, 30) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(32, app.items[0].quality);
        }

        @Test
        void _Item名がBackstagePassesでSellIn値が1の場合更新するとQuality値は3増える() {
            items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 1, 30) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(33, app.items[0].quality);
        }

        @Test
        void _Item名がBackstagePassesでSellIn値が0の場合更新するとQuality値が0になる() {
            items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 30) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(0, app.items[0].quality);
        }
    }

}
