package com.gildedrose;

import com.gildedrose.strategies.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Main class for the Gilded Rose inventory management system.
 * Uses the Strategy pattern to handle different types of items.
 */
class GildedRose {
    /**
     * Array of items in the inventory.
     */
    Item[] items;

    /**
     * Map of item names to their corresponding update strategies.
     */
    private final Map<String, ItemUpdateStrategy> strategies;

    /**
     * Creates a new GildedRose instance with the specified items.
     * Initializes the strategy map for different types of items.
     * @param items Array of items to manage
     */
    public GildedRose(Item[] items) {
        this.items = items;
        this.strategies = new HashMap<>();
        initializeStrategies();
    }

    /**
     * Initializes the strategy map with appropriate strategies for each item type.
     */
    private void initializeStrategies() {
        strategies.put("Aged Brie", new AgedBrieStrategy());
        strategies.put("Backstage passes to a TAFKAL80ETC concert", new BackstagePassStrategy());
        strategies.put("Sulfuras, Hand of Ragnaros", new SulfurasStrategy());
        strategies.put("Conjured", new ConjuredItemStrategy());
    }

    /**
     * Updates the quality and sellIn values for all items in the inventory.
     * Uses appropriate strategies based on item type.
     */
    public void updateQuality() {
        for (Item item : items) {
            ItemUpdateStrategy strategy = getStrategy(item);
            strategy.updateQuality(item);
        }
    }

    /**
     * Gets the appropriate strategy for an item based on its name.
     * @param item The item to get the strategy for
     * @return The strategy to use for updating the item
     */
    private ItemUpdateStrategy getStrategy(Item item) {
        if (item.name.startsWith("Conjured")) {
            return strategies.get("Conjured");
        }
        return strategies.getOrDefault(item.name, new StandardItemStrategy());
    }
}