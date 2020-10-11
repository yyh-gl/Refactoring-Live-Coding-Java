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
        
        if (isAgedBrie(item) || isBackstagePasses(item)) {
            if (item.quality < 50) {
                incrementQuality(item);

                if (isBackstagePasses(item)) {
                    if (item.sellIn < 11) {
                        if (item.quality < 50) {
                            incrementQuality(item);
                        }
                    }

                    if (item.sellIn < 6) {
                        if (item.quality < 50) {
                            incrementQuality(item);
                        }
                    }
                }
            }
        } else {
            if (item.quality > 0) {
                    decreaseQuality(item);
            }
        }

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            if (isAgedBrie(item)) {
                if (item.quality < 50) {
                    incrementQuality(item);
                }
            } else {
                if (isBackstagePasses(item)) {
                    item.quality = item.quality - item.quality;
                } else {
                    if (item.quality > 0) {
                        decreaseQuality(item);
                    }
                }
            }
        }
    }

    private void decreaseQuality(Item item) {
        item.quality = item.quality - 1;
    }

    private void incrementQuality(Item item) {
        item.quality = item.quality + 1;
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
