package com.gildedrose.items;

import com.gildedrose.Item;

public class BackstagePass extends Item {

    private static final String backstagePass = "Backstage passes to a TAFKAL80ETC concert";

    public BackstagePass(int sellIn, int quality) {
        super(backstagePass, sellIn, quality);
    }

    @Override
    public void updateQualityWhenExpired() {
        if (sellIn < 0)
            quality = 0;
    }

    @Override
    public void updateQuality() {
        if (quality < 50) {
            quality = quality + 1;
            if (sellIn < 11 && quality < 50) {
                quality = quality + 1;
            }
            if (sellIn < 6 && quality < 50) {
                quality = quality + 1;
            }
        }
    }
}
