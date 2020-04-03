package tv.codely.kata.gildedrose.domain;

public class ItemFactory {

    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    public Item createItem(String name, int sellIn, int quality){
        switch(name) {
            case SULFURAS:
                return new SulfurasItem(name, sellIn, quality);
            case BACKSTAGE_PASSES:
                return new BackstageItem(name, sellIn, quality);
            case AGED_BRIE:
                return new AgedBrieItem(name, sellIn, quality);
            default:
                return new StandardItem(name, sellIn, quality);
        }
    }
}
