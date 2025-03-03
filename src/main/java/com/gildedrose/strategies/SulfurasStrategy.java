package com.gildedrose.strategies;

import com.gildedrose.Item;
import com.gildedrose.ItemUpdateStrategy;

/**
 * Strategy for handling Sulfuras items.
 * Sulfuras is a legendary item that never has to be sold
 * and never decreases in Quality.
 */
public class SulfurasStrategy implements ItemUpdateStrategy {
    /**
     * Updates the quality of a Sulfuras item.
     * Sulfuras never changes in quality (always 80)
     * and never has to be sold.
     * @param item The Sulfuras item to update
     */
    @Override
    public void updateQuality(Item item) {
        // Sulfuras never changes mesh me7taga
    }
} 