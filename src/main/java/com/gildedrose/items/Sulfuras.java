package com.gildedrose.items;

import com.gildedrose.Item;

public class Sulfuras extends Item {

    private static final String sulfuras = "Sulfuras, Hand of Ragnaros";

    public Sulfuras(int sellIn, int quality) {
        super(sulfuras, sellIn, quality);
    }

    @Override
    public void updateSellIn() {
    }

    @Override
    public void updateQualityWhenExpired() {
    }

    @Override
    public void updateQuality() {
    }
}
