package tv.codely.kata.gildedrose.domain;

public class BackstageItem extends Item {

    public BackstageItem(ItemName name, ItemSellIn sellIn, ItemQuality quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void update() {
        increaseBackstagePassesQuality();

        sellIn = sellIn.decrease();

        if (sellIn.isSellByDateHasPassed()) {
            quality = new ItemQuality(decreaser.apply(quality.getQuality(), quality.getQuality()));
        }
    }

    private void increaseBackstagePassesQuality() {
        quality = quality.increase();

        if (isConcertApproaching(this)) {
            quality = quality.increase();
        }

        if (isConcertAlreadyHere(this)) {
            quality = quality.increase();
        }
    }


    private boolean isConcertAlreadyHere(Item item) {
        return item.sellIn.getSellIn() < DAYS_TO_FEW_DAYS_LEFT_TO_CONCERT;
    }

    private boolean isConcertApproaching(Item item) {
        return item.sellIn.getSellIn() < DAYS_TO_CONCERT_IS_APPROACHING;
    }
}
