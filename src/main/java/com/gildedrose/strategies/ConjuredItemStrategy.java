package com.gildedrose.strategies;

import com.gildedrose.Item;
import com.gildedrose.ItemUpdateStrategy;

/**
 * Strategy for handling Conjured items.
 * Conjured items degrade in Quality twice as fast as normal items.
 */
public class ConjuredItemStrategy implements ItemUpdateStrategy {
    /**
     * Updates the quality of a Conjured item.
     * - Quality decreases by 2 each day
     * - Quality decreases by 4 after sell by date
     * - Quality is never negative
     * @param item The Conjured item to update
     */
    @Override
    public void updateQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 2;
        }
        
        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0 && item.quality > 0) {
            item.quality = item.quality - 2;
        }

        // Ensure quality never goes below 0
        if (item.quality < 0) {
            item.quality = 0;
        }
    }
} 