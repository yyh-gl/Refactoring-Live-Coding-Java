package com.gildedrose;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    void decreaseSellIn() {
        sellIn = sellIn - 1;
    }
    
    void decreaseQuality() {
       quality = quality - 1;
    }

    void increaseQuality() {
        quality = quality + 1;
    }

    boolean lessThanMaxQuality() {
        return quality < 50; 
    }

    boolean moreThanMinQuality() {
        return quality > 0;
    }

    boolean isEndOfSales() {
        return sellIn < 0;
    }
}
