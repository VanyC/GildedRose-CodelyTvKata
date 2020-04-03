package tv.codely.kata.gildedrose.domain;

public class ItemFactory {

    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    public Item createItem(String name, int sellIn, int quality){
        ItemName itemName = new ItemName(name);
        ItemSellIn itemSellIn = new ItemSellIn(sellIn);
        ItemQuality itemQuality = new ItemQuality(quality);

        switch(itemName.getName()) {
            case SULFURAS:
                return new SulfurasItem(itemName, itemSellIn, itemQuality);
            case BACKSTAGE_PASSES:
                return new BackstageItem(itemName, itemSellIn, itemQuality);
            case AGED_BRIE:
                return new AgedBrieItem(itemName, itemSellIn, itemQuality);
            default:
                return new StandardItem(itemName, itemSellIn, itemQuality);
        }
    }
}
