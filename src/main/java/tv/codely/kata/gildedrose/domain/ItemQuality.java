package tv.codely.kata.gildedrose.domain;

public class ItemQuality {

    private Integer quality;

    public ItemQuality(Integer quality) {
        this.quality = quality;
    }

    public Integer getQuality() {
        return quality;
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
}
