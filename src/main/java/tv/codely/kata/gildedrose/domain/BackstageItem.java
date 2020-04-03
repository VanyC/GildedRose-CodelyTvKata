package tv.codely.kata.gildedrose.domain;

public class BackstageItem extends Item {

    public BackstageItem(ItemName name, ItemSellIn sellIn, ItemQuality quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void update() {
        increaseBackstagePassesQuality();

        decreaseSellIn();

        if (isSellByDateHasPassed(this)) {
            this.quality = new ItemQuality(decreaser.apply(this.quality.getQuality(), this.quality.getQuality()));
        }
    }

    private void increaseBackstagePassesQuality() {
        if (isNotHighestQuality(this)) {
            this.quality = new ItemQuality(increaser.apply(this.quality.getQuality(), QUALITY_QUANTITY_TO_INCREASE));

            if (isConcertApproaching(this)) {
                increaseQuality();
            }

            if (isConcertAlreadyHere(this)) {
                increaseQuality();
            }
        }
    }

    private boolean isConcertAlreadyHere(Item item) {
        return item.sellIn.getSellIn() < DAYS_TO_FEW_DAYS_LEFT_TO_CONCERT;
    }

    private boolean isConcertApproaching(Item item) {
        return item.sellIn.getSellIn() < DAYS_TO_CONCERT_IS_APPROACHING;
    }
}
