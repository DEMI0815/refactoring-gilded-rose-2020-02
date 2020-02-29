package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public static final String backstagePasses = "Backstage passes to a TAFKAL80ETC concert";
    public static final String agedBrie = "Aged Brie";
    public static final String sulfuras = "Sulfuras, Hand of Ragnaros";

    public void updateItemsInOneDay() {
        for (Item item : items) {
            item.updateItem();
        }
    }

}
