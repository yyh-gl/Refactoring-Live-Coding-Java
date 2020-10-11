package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            updateItem(items[i]);
        }
    }

    public void updateItem(Item item) {
        if (isSulfuras(item)) {
            return;
        }

        if (isAgedBrie(item)) {
            GildedRoseItem agedBrieItem = new AgedBrieItem();
            agedBrieItem.updateSellIn(item);
            agedBrieItem.updateQuality(item);
        } else if (isBackstagePasses(item)) {
            GildedRoseItem backstagePassesItem = new BackstagePassesItem();
            backstagePassesItem.updateSellIn(item);
            backstagePassesItem.updateQuality(item);
        } else {
            decreaseSellIn(item);
            updateNormalQuality(item);
        }
    }

    private void updateNormalQuality(Item item) {
        if (item.quality > 0) {
            decreaseQuality(item);
        }

        if (item.sellIn < 0) {
            if (item.quality > 0) {
                decreaseQuality(item);
            }
        }
    }

    private void decreaseSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private void decreaseQuality(Item item) {
        item.quality = item.quality - 1;
    }

    private boolean isSulfuras(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    private boolean isBackstagePasses(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isAgedBrie(Item item) {
        return item.name.equals("Aged Brie");
    }
}
