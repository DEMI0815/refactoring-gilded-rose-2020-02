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
        increaseQuality();

        if (sellIn < 11) {
            increaseQuality();
        }

        if (sellIn < 6) {
            increaseQuality();
        }
    }

}
