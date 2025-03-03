package com.gildedrose;

/**
 * Strategy interface for updating item quality.
 * Each type of item will have its own implementation of this interface.
 */
public interface ItemUpdateStrategy {
    /**
     * Updates the quality and sellIn values of an item according to its specific rules.
     * @param item The item to update
     */
    void updateQuality(Item item);
} 