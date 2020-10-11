package com.gildedrose;

public class AgedBrieItem implements GildedRoseItemInterface {
    @Override
    public void updateSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    @Override
    public void updateQuality(Item item) {
        if (item.quality < 50) {
            incrementQuality(item);
        }
        if (item.sellIn < 0) {
            if (item.quality < 50) {
                incrementQuality(item);
            }
        }
    }

    private void incrementQuality(Item item) {
        item.quality = item.quality + 1;
    }
}
