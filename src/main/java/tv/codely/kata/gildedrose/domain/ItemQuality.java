package tv.codely.kata.gildedrose.domain;

public class ItemQuality {

    private static final int MAX_VALUE = 50;
    private static final int MIN_VALUE = 0;
    private static final int QUANTITY_TO_MODIFY = 1;

    private Integer quality;

    public ItemQuality(Integer quality) {
        this.quality = quality;
    }

    public Integer getQuality() {
        return quality;
    }

    public ItemQuality decrease() {
        if (isNotWorstQuality()) {
            return new ItemQuality(quality - QUANTITY_TO_MODIFY);
        }
        return this;
    }

    public ItemQuality increase() {
        if (isNotHighestQuality()) {
            return new ItemQuality(quality + QUANTITY_TO_MODIFY);
        }
        return this;
    }

    public ItemQuality reset() {
        return new ItemQuality(MIN_VALUE);
    }

    private boolean isNotHighestQuality() {
        return quality < MAX_VALUE;
    }

    private boolean isNotWorstQuality() {
        return quality > MIN_VALUE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemQuality that = (ItemQuality) o;

        return quality != null ? quality.equals(that.quality) : that.quality == null;
    }

    @Override
    public int hashCode() {
        return quality != null ? quality.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "ItemQuality{" +
                "quality=" + quality +
                '}';
    }
}
