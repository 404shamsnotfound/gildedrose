package com.gildedrose.strategies;

import com.gildedrose.Item;
import com.gildedrose.ItemUpdateStrategy;

/**
 * Strategy for handling standard (normal) items.
 * Standard items degrade in quality over time according to basic rules.
 */
public class StandardItemStrategy implements ItemUpdateStrategy {
    /**
     * Updates the quality of a standard item.
     * - Quality decreases by 1 each day
     * - Quality decreases twice as fast after sell by date
     * - Quality is never negative
     * @param item The standard item to update
     */
    @Override
    public void updateQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
        
        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0 && item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }
} 