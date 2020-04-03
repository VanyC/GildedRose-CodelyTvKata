package tv.codely.kata.gildedrose.domain;

public class StandardItem extends Item {

    public StandardItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void update() {
        decreaseQuality();

        decreaseSellIn();

        if (isSellByDateHasPassed(this)) {
            decreaseQuality();
        }
    }
}
