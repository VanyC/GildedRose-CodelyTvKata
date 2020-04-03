package tv.codely.kata.gildedrose.domain;

public class AgedBrieItem extends Item {

    public AgedBrieItem(ItemName name, ItemSellIn sellIn, ItemQuality quality)  {
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
