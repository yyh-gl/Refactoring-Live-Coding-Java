package com.gildedrose;

public class AgedBrieItem implements GildedRoseItemInterface {
    @Override
    public void updateSellIn(Item item) {
        item.decreaseSellIn();
    }

    @Override
    public void updateQuality(Item item) {
        if (item.lessThanMaxQuality()) {
            item.increaseQuality();
        }
        if (item.isEndOfSales()) {
            if (item.lessThanMaxQuality()) {
                item.increaseQuality();
            }
        }
    }
}
