package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    private static final String backstagePasses = "Backstage passes to a TAFKAL80ETC concert";
    private static final String agedBrie = "Aged Brie";
    private static final String sulfuras = "Sulfuras, Hand of Ragnaros";

    public void update_quality() {
        for (Item item : items) {
            updateItem(item);
        }
    }

    private void updateItem(Item item) {
        updateQuality(item);

        updateSellIn(item);

        updateQualityWhenExpired(item);
    }

    private void updateQualityWhenExpired(Item item) {
        if (item.sell_in < 0) {
            if (!item.isNameEquals(agedBrie)) {
                if (!item.isNameEquals(backstagePasses)) {
                    if (item.quality > 0) {
                        if (!item.isNameEquals(sulfuras)) {
                            item.quality = item.quality - 1;
                        }
                    }
                } else {
                    item.quality = 0;
                }
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }
        }
    }

    private void updateSellIn(Item item) {
        if (!item.isNameEquals(sulfuras)) {
            item.sell_in = item.sell_in - 1;
        }
    }

    private void updateQuality(Item item) {
        if (!item.isNameEquals(agedBrie)
                && !item.isNameEquals(backstagePasses)) {
            if (item.quality > 0) {
                if (!item.isNameEquals(sulfuras)) {
                    item.quality = item.quality - 1;
                }
            }
        } else {
            if (item.quality < 50) {
                item.quality = item.quality + 1;

                if (item.isNameEquals(backstagePasses)) {
                    if (item.sell_in < 11) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }

                    if (item.sell_in < 6) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }
                }
            }
        }
    }

}
