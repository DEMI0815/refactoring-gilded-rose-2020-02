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

    void updateItem() {
        updateQuality();

        updateSellIn();

        updateQualityWhenExpired();
    }

    boolean isNameEquals(String name) {
        return this.name.equals(name);
    }

    void updateQualityWhenExpired() {
        if (sellIn < 0) {
            if (!isNameEquals(GildedRose.agedBrie)) {
                if (!isNameEquals(GildedRose.backstagePasses)) {
                    if (quality > 0) {
                        if (!isNameEquals(GildedRose.sulfuras)) {
                            quality = quality - 1;
                        }
                    }
                } else {
                    quality = 0;
                }
            } else {
                if (quality < 50) {
                    quality = quality + 1;
                }
            }
        }
    }

    void updateSellIn() {
        if (!isNameEquals(GildedRose.sulfuras)) {
            sellIn = sellIn - 1;
        }
    }

    void updateQuality() {
        if (!isNameEquals(GildedRose.agedBrie)
                && !isNameEquals(GildedRose.backstagePasses)) {
            if (quality > 0) {
                if (!isNameEquals(GildedRose.sulfuras)) {
                    quality = quality - 1;
                }
            }
        } else {
            if (quality < 50) {
                quality = quality + 1;

                if (isNameEquals(GildedRose.backstagePasses)) {
                    if (sellIn < 11) {
                        if (quality < 50) {
                            quality = quality + 1;
                        }
                    }

                    if (sellIn < 6) {
                        if (quality < 50) {
                            quality = quality + 1;
                        }
                    }
                }
            }
        }
    }
}
