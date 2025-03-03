package com.gildedrose;

/**
 * Represents an item in the Gilded Rose inventory system.
 * This class should not be modified as per requirements.
 */
public class Item {

    /**
     * The name of the item.
     */
    public String name;

    /**
     * The number of days remaining to sell the item.
     */
    public int sellIn;

    /**
     * The quality value of the item, representing how valuable it is.
     */
    public int quality;

    /**
     * Creates a new Item with specified attributes.
     * @param name The name of the item
     * @param sellIn Number of days to sell the item
     * @param quality The quality value of the item
     */
    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    /**
     * Returns a string representation of the item.
     * @return String in format "name, sellIn, quality"
     */
    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
