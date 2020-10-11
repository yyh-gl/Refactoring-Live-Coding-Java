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
            GildedRoseItemInterface sulfurasItem = new SulfurasItem();
            sulfurasItem.updateSellIn(item);
            sulfurasItem.updateQuality(item);
            return;
        }

        if (isAgedBrie(item)) {
            GildedRoseItemInterface agedBrieItem = new AgedBrieItem();
            agedBrieItem.updateSellIn(item);
            agedBrieItem.updateQuality(item);
        } else if (isBackstagePasses(item)) {
            GildedRoseItemInterface backstagePassesItem = new BackstagePassesItem();
            backstagePassesItem.updateSellIn(item);
            backstagePassesItem.updateQuality(item);
        } else {
            GildedRoseItemInterface normalItem = new NormalItem();
            normalItem.updateSellIn(item);
            normalItem.updateQuality(item);
        }
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
