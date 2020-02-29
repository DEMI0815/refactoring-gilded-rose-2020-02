package com.gildedrose.items;

import com.gildedrose.Item;

public class AgedBrie extends Item {

    private static final String agedBrie = "Aged Brie";

    public AgedBrie(int sellIn, int quality) {
        super(agedBrie, sellIn, quality);
    }

    @Override
    public void updateQualityWhenExpired() {
        if (sellIn < 0 && quality < 50)
            quality = quality + 1;
    }

    @Override
    public void updateQuality() {
        if (quality < 50) {
            quality = quality + 1;
        }
    }
}
