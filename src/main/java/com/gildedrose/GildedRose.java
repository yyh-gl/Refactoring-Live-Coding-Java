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
        GildedRoseItemInterface gildedRoseItem;
        if (isSulfuras(item)) {
            gildedRoseItem = new SulfurasItem();
        } else if (isAgedBrie(item)) {
            gildedRoseItem = new AgedBrieItem();
        } else if (isBackstagePasses(item)) {
            gildedRoseItem = new BackstagePassesItem();
        } else {
            gildedRoseItem = new NormalItem();
        }
        gildedRoseItem.updateSellIn(item);
        gildedRoseItem.updateQuality(item);
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
