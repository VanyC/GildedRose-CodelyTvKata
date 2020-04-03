package tv.codely.kata.gildedrose.domain;

import java.util.function.BinaryOperator;

abstract public class Item {

    public static final int DAYS_TO_CONCERT_IS_APPROACHING = 11;
    public static final int DAYS_TO_FEW_DAYS_LEFT_TO_CONCERT = 6;

    public ItemName name;
    public ItemSellIn sellIn;
    public ItemQuality quality;

    public Item(ItemName name, ItemSellIn sellIn, ItemQuality quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    abstract public void update();


    protected final BinaryOperator<Integer> decreaser = (itemToDecrease, quantityToDecrease)
            -> itemToDecrease - quantityToDecrease;

    protected final BinaryOperator<Integer> increaser = (itemToIncrease, quantityToIncrease)
            -> itemToIncrease + quantityToIncrease;

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (name != null ? !name.equals(item.name) : item.name != null) return false;
        if (sellIn != null ? !sellIn.equals(item.sellIn) : item.sellIn != null) return false;
        if (quality != null ? !quality.equals(item.quality) : item.quality != null) return false;
        if (decreaser != null ? !decreaser.equals(item.decreaser) : item.decreaser != null) return false;
        return increaser != null ? increaser.equals(item.increaser) : item.increaser == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (sellIn != null ? sellIn.hashCode() : 0);
        result = 31 * result + (quality != null ? quality.hashCode() : 0);
        result = 31 * result + (decreaser != null ? decreaser.hashCode() : 0);
        result = 31 * result + (increaser != null ? increaser.hashCode() : 0);
        return result;
    }
}
