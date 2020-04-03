package tv.codely.kata.gildedrose.domain;

public class ItemQuality {

    public static final int MAX_QUALITY_VALUE = 50;
    public static final int MIN_QUALITY_VALUE = 0;
    public static final int QUALITY_QUANTITY_TO_DECREASE = 1;
    public static final int QUALITY_QUANTITY_TO_INCREASE = 1;

    private Integer quality;

    public ItemQuality(Integer quality) {
        this.quality = quality;
    }

    public Integer getQuality() {
        return quality;
    }

    private boolean isNotHighestQuality() {
        return quality < MAX_QUALITY_VALUE;
    }

    private boolean isNotWorstQuality() {
        return quality > MIN_QUALITY_VALUE;
    }

    protected ItemQuality decrease() {
        if (isNotWorstQuality()) {
            return new ItemQuality(quality - QUALITY_QUANTITY_TO_DECREASE);
        }
        return this;
    }

    protected ItemQuality increase() {
        if (isNotHighestQuality()) {
            return new ItemQuality(quality + QUALITY_QUANTITY_TO_INCREASE);
        }
        return this;
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
