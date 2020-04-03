package tv.codely.kata.gildedrose.domain;

abstract public class Item {

    public ItemName name;
    public ItemSellIn sellIn;
    public ItemQuality quality;

    public Item(ItemName name, ItemSellIn sellIn, ItemQuality quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    abstract public void update();

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
        return quality != null ? quality.equals(item.quality) : item.quality == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (sellIn != null ? sellIn.hashCode() : 0);
        result = 31 * result + (quality != null ? quality.hashCode() : 0);
        return result;
    }
}
