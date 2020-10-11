package com.gildedrose;

public class NormalItem implements GildedRoseItemInterface {
    @Override
    public void updateSellIn(Item item) {
        item.decreaseSellIn();
    }

    @Override
    public void updateQuality(Item item) {
        if (item.moreThanMinQuality()) {
            item.decreaseQuality();
        }

        if (item.isEndOfSales()) {
            if (item.moreThanMinQuality()) {
                item.decreaseQuality();
            }
        }
    }
}
