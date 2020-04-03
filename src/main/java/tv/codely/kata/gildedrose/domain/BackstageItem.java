package tv.codely.kata.gildedrose.domain;

public class BackstageItem extends Item {

    private static final int DAYS_TO_CONCERT_IS_APPROACHING = 11;
    private static final int DAYS_TO_FEW_DAYS_LEFT_TO_CONCERT = 6;

    public BackstageItem(ItemName name, ItemSellIn sellIn, ItemQuality quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void update() {
        increaseBackstagePassesQuality();

        sellIn = sellIn.decrease();

        if (sellIn.isSellByDateHasPassed()) {
            quality = quality.reset();
        }
    }

    private void increaseBackstagePassesQuality() {
        quality = quality.increase();

        if (isConcertApproaching()) {
            quality = quality.increase();
        }

        if (isConcertAlreadyHere()) {
            quality = quality.increase();
        }
    }

    private boolean isConcertAlreadyHere() {
        return sellIn.getSellIn() < DAYS_TO_FEW_DAYS_LEFT_TO_CONCERT;
    }

    private boolean isConcertApproaching() {
        return sellIn.getSellIn() < DAYS_TO_CONCERT_IS_APPROACHING;
    }
}
