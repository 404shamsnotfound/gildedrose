package com.gildedrose.strategies;

import com.gildedrose.Item;
import com.gildedrose.ItemUpdateStrategy;

/**
 * Strategy for handling Aged Brie items.
 * Aged Brie actually increases in Quality the older it gets.
 * Quality increases twice as fast after the sell by date.
 */
public class AgedBrieStrategy implements ItemUpdateStrategy {
    /**
     * Updates the quality of an Aged Brie item.
     * - Quality increases by 1 each day
     * - Quality increases by 2 after sell by date
     * - Quality never exceeds 50
     * @param item The Aged Brie item to update
     */
    @Override
    public void updateQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0 && item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }
} 