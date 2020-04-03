package tv.codely.kata.gildedrose.domain;

public class StandardItem extends Item {

    public StandardItem(ItemName name, ItemSellIn sellIn, ItemQuality quality)  {
        super(name, sellIn, quality);
    }

    @Override
    public void update() {
        quality = quality.decrease();

        decreaseSellIn();

        if (isSellByDateHasPassed(this)) {
            quality = quality.decrease();
        }
    }
}
