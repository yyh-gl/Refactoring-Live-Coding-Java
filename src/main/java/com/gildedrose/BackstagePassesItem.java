package com.gildedrose;

public class BackstagePassesItem implements GildedRoseItemInterface {
    @Override
    public void updateSellIn(Item item) {
        item.decreaseSellIn();
    }

    @Override
    public void updateQuality(Item item) {
        if (item.lessThanMaxQuality()) {
            item.increaseQuality();

            // item.sellIn < 10 はItemクラスで共通化しない
            // → BackstagePassesItem特有の処理であるため
            if (item.sellIn < 10) {
                if (item.lessThanMaxQuality()) {
                    item.increaseQuality();
                }
            }

            if (item.sellIn < 5) {
                if (item.lessThanMaxQuality()) {
                    item.increaseQuality();
                }
            }

            if (item.isEndOfSales()) {
                item.quality = 0;
            }
        }
    }
}
