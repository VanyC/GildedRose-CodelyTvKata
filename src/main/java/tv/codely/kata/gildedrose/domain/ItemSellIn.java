package tv.codely.kata.gildedrose.domain;

public class ItemSellIn {

    public static final int MIN_SELLIN_DAYS = 0;
    public static final int SELLIN_QUANTITY_TO_DECREASE = 1;

    private Integer sellIn;

    public ItemSellIn(Integer sellIn) {
        this.sellIn = sellIn;
    }

    public Integer getSellIn() {
        return sellIn;
    }

    public ItemSellIn decrease() {
        if (!isSellByDateHasPassed()) {
            return new ItemSellIn(sellIn - SELLIN_QUANTITY_TO_DECREASE);
        }
        return this;
    }

    public boolean isSellByDateHasPassed() {
        return sellIn < MIN_SELLIN_DAYS;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemSellIn that = (ItemSellIn) o;

        return sellIn != null ? sellIn.equals(that.sellIn) : that.sellIn == null;
    }

    @Override
    public int hashCode() {
        return sellIn != null ? sellIn.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "ItemSellIn{" +
                "sellIn=" + sellIn +
                '}';
    }
}
