package tv.codely.kata.gildedrose.domain;

public class AgedBrieItem extends Item {

    public AgedBrieItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void update() {
        increaseQuality();

        decreaseSellIn();

        if (isSellByDateHasPassed(this)) {
            increaseQuality();
        }
    }
}
