package tv.codely.kata.gildedrose.domain;

public class ItemSellIn {

    private Integer sellIn;

    public ItemSellIn(Integer sellIn) {
        this.sellIn = sellIn;
    }

    public Integer getSellIn() {
        return sellIn;
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
}
