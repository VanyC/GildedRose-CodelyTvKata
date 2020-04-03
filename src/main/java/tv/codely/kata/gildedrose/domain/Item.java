package tv.codely.kata.gildedrose.domain;

import java.util.function.BinaryOperator;

public class Item {

    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

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

    public void update() {
        switch(this.name) {
            case SULFURAS:
                break;
            case BACKSTAGE_PASSES:
                if (isNotHighestQuality(this)) {
                    this.quality = increaser.apply(this.quality, QUALITY_QUANTITY_TO_INCREASE);

                    if (isConcertApproaching(this)) {
                        if (isNotHighestQuality(this)) {
                            this.quality = increaser.apply(this.quality, QUALITY_QUANTITY_TO_INCREASE);
                        }
                    }

                    if (isConcertAlreadyHere(this)) {
                        if (isNotHighestQuality(this)) {
                            this.quality = increaser.apply(this.quality, QUALITY_QUANTITY_TO_INCREASE);
                        }
                    }
                }

                this.sellIn = decreaser.apply(this.sellIn, SELLIN_QUANTITY_TO_DECREASE);

                if (isSellByDateHasPassed(this)) {
                    this.quality = decreaser.apply(this.quality, this.quality);
                }

                break;
            case AGED_BRIE:
                if (isNotHighestQuality(this)) {
                    this.quality = increaser.apply(this.quality, QUALITY_QUANTITY_TO_INCREASE);
                }

                this.sellIn = decreaser.apply(this.sellIn, SELLIN_QUANTITY_TO_DECREASE);

                if (isSellByDateHasPassed(this)) {
                    if (isNotHighestQuality(this)) {
                        this.quality = increaser.apply(this.quality, QUALITY_QUANTITY_TO_INCREASE);
                    }
                }

                break;
            default:
                if (isNotWorstQuality(this)) {
                    this.quality = decreaser.apply(this.quality, QUALITY_QUANTITY_TO_DECREASE);
                }

                this.sellIn = decreaser.apply(this.sellIn, SELLIN_QUANTITY_TO_DECREASE);

                if (isSellByDateHasPassed(this)) {
                    if (isNotWorstQuality(this)) {
                        this.quality = decreaser.apply(this.quality, QUALITY_QUANTITY_TO_DECREASE);
                    }
                }

                break;
        }
    }

    private boolean isNotWorstQuality(Item item) {
        return item.quality > MIN_QUALITY_VALUE;
    }

    private boolean isSellByDateHasPassed(Item item) {
        return item.sellIn < MIN_SELLIN_DAYS;
    }

    private boolean isNotHighestQuality(Item item) {
        return item.quality < MAX_QUALITY_VALUE;
    }

    private boolean isConcertAlreadyHere(Item item) {
        return item.sellIn < DAYS_TO_FEW_DAYS_LEFT_TO_CONCERT;
    }

    private boolean isConcertApproaching(Item item) {
        return item.sellIn < DAYS_TO_CONCERT_IS_APPROACHING;
    }

    private final BinaryOperator<Integer> decreaser = (itemToDecrease, quantityToDecrease)
            -> itemToDecrease - quantityToDecrease;

    private final BinaryOperator<Integer> increaser = (itemToIncrease, quantityToIncrease)
            -> itemToIncrease + quantityToIncrease;

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
