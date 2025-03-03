package com.gildedrose.strategies;

import com.gildedrose.Item;
import com.gildedrose.ItemUpdateStrategy;

/**
 * Strategy for handling Backstage passes items.
 * Quality increases as the sell date approaches:
 * - Increases by 1 when more than 10 days
 * - Increases by 2 when 10 days or less
 * - Increases by 3 when 5 days or less
 * - Drops to 0 after the concert (sellIn < 0)
 */
public class BackstagePassStrategy implements ItemUpdateStrategy {
    /**
     * Updates the quality of a Backstage pass item.
     * Quality increases more as the concert date approaches,
     * then drops to 0 after the concert.
     * @param item The Backstage pass item to update
     */
    @Override
    public void updateQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;

            if (item.sellIn <= 10 && item.quality < 50) {
                item.quality = item.quality + 1;
            }

            if (item.sellIn <= 5 && item.quality < 50) {
                item.quality = item.quality + 1;
            }
        }

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }
} 