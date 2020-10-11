package com.gildedrose;

public class NormalItem implements GildedRoseItem {
    @Override
    public void updateSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    @Override
    public void updateQuality(Item item) {
        if (item.quality > 0) {
            decreaseQuality(item);
        }

        if (item.sellIn < 0) {
            if (item.quality > 0) {
                decreaseQuality(item);
            }
        }
    }

    private void decreaseQuality(Item item) {
        item.quality = item.quality - 1;
    }
}
