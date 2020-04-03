package tv.codely.kata.gildedrose.domain;

import java.util.function.BinaryOperator;

abstract public class Item {

    public static final int MAX_QUALITY_VALUE = 50;
    public static final int MIN_QUALITY_VALUE = 0;
    public static final int QUALITY_QUANTITY_TO_DECREASE = 1;
    public static final int QUALITY_QUANTITY_TO_INCREASE = 1;

    public static final int DAYS_TO_CONCERT_IS_APPROACHING = 11;
    public static final int DAYS_TO_FEW_DAYS_LEFT_TO_CONCERT = 6;

    public static final int MIN_SELLIN_DAYS = 0;
    public static final int SELLIN_QUANTITY_TO_DECREASE = 1;

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    abstract public void update();

    protected void decreaseSellIn() {
        this.sellIn = decreaser.apply(this.sellIn, SELLIN_QUANTITY_TO_DECREASE);
    }

    protected void decreaseQuality() {
        if (isNotWorstQuality(this)) {
            this.quality = decreaser.apply(this.quality, QUALITY_QUANTITY_TO_DECREASE);
        }
    }

    protected void increaseQuality() {
        if (isNotHighestQuality(this)) {
            this.quality = increaser.apply(this.quality, QUALITY_QUANTITY_TO_INCREASE);
        }
    }

    protected boolean isNotWorstQuality(Item item) {
        return item.quality > MIN_QUALITY_VALUE;
    }

    protected boolean isSellByDateHasPassed(Item item) {
        return item.sellIn < MIN_SELLIN_DAYS;
    }

    protected boolean isNotHighestQuality(Item item) {
        return item.quality < MAX_QUALITY_VALUE;
    }

    protected final BinaryOperator<Integer> decreaser = (itemToDecrease, quantityToDecrease)
            -> itemToDecrease - quantityToDecrease;

    protected final BinaryOperator<Integer> increaser = (itemToIncrease, quantityToIncrease)
            -> itemToIncrease + quantityToIncrease;

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
