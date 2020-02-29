package com.gildedrose;

import com.gildedrose.items.AgedBrie;
import com.gildedrose.items.BackstagePass;
import com.gildedrose.items.Sulfuras;

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
            if (!isNameEquals(AgedBrie.agedBrie)) {
                if (!isNameEquals(BackstagePass.backstagePass)) {
                    if (quality > 0) {
                        if (!isNameEquals(Sulfuras.sulfuras)) {
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
        if (!isNameEquals(Sulfuras.sulfuras)) {
            sellIn = sellIn - 1;
        }
    }

    void updateQuality() {
        if (!isNameEquals(AgedBrie.agedBrie)
                && !isNameEquals(BackstagePass.backstagePass)) {
            if (quality > 0) {
                if (!isNameEquals(Sulfuras.sulfuras)) {
                    quality = quality - 1;
                }
            }
        } else {
            if (quality < 50) {
                quality = quality + 1;

                if (isNameEquals(BackstagePass.backstagePass)) {
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
