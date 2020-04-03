package tv.codely.kata.gildedrose;

import org.junit.jupiter.api.Test;
import tv.codely.kata.gildedrose.application.GildedRose;
import tv.codely.kata.gildedrose.domain.Item;
import tv.codely.kata.gildedrose.domain.ItemFactory;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseShould {
    private List<Item> arrayWith(Item item) {
        return Collections.singletonList(item);
    }

    @Test
    public void testThatSellInValueIsDecreased() {
        ItemFactory itemFactory = new ItemFactory();
        Item whateverItem = itemFactory.createItem("whatever", 10, 0);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(arrayWith(whateverItem));

        assertEquals(whateverItem.sellIn, 9);
    }

    @Test
    public void testThatQualityValueIsDecreased() {
        ItemFactory itemFactory = new ItemFactory();
        Item whateverItem = itemFactory.createItem("whatever", 1, 10);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(arrayWith(whateverItem));

        assertEquals(whateverItem.quality, 9);
    }

    @Test
    public void testThatQualityDecreasesTwiceAsMuchWhenSellByIsPassed() {
        ItemFactory itemFactory = new ItemFactory();
        Item whateverItem = itemFactory.createItem("whatever", 0, 10);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(arrayWith(whateverItem));

        assertEquals(whateverItem.quality, 8);
    }

    @Test
    public void testThatQualityIsNeverNegative() {
        ItemFactory itemFactory = new ItemFactory();
        Item whateverItem = itemFactory.createItem("whatever", 0, 0);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(arrayWith(whateverItem));

        assertEquals(whateverItem.quality, 0);
    }

    @Test
    public void testAgedBrieIncreasesQualityWithAge() {
        ItemFactory itemFactory = new ItemFactory();
        Item agedBrie = itemFactory.createItem("Aged Brie", 5, 1);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(arrayWith(agedBrie));

        assertEquals(agedBrie.quality, 2);
    }

    @Test
    public void testQualityNeverIncreasesPastFifty() {
        ItemFactory itemFactory = new ItemFactory();
        Item agedBrie = itemFactory.createItem("Aged Brie", 5, 50);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(arrayWith(agedBrie));

        assertEquals(agedBrie.quality, 50);
    }

    @Test
    public void testSulfurasNeverChanges() {
        ItemFactory itemFactory = new ItemFactory();
        Item sulfuras = itemFactory.createItem("Sulfuras, Hand of Ragnaros", 0, 25);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(arrayWith(sulfuras));

        assertEquals(sulfuras.quality, 25);
        assertEquals(sulfuras.sellIn, 0);
    }

    @Test
    public void testBackstagePassIncreasesQualityByOneIfSellByGreaterThenTen() {
        ItemFactory itemFactory = new ItemFactory();
        Item backstagePasses = itemFactory.createItem("Backstage passes to a TAFKAL80ETC concert", 11, 20);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(arrayWith(backstagePasses));

        assertEquals(backstagePasses.quality, 21);
    }

    @Test
    public void testBackstagePassIncreasesQualityByTwoIfSellBySmallerThanTen() {
        ItemFactory itemFactory = new ItemFactory();
        Item backstagePasses = itemFactory.createItem("Backstage passes to a TAFKAL80ETC concert", 6, 20);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(arrayWith(backstagePasses));

        assertEquals(backstagePasses.quality, 22);
    }

    @Test
    public void testBackstagePassIncreasesQualityByThreeIfSellBySmallerThanFive() {
        ItemFactory itemFactory = new ItemFactory();
        Item backstagePasses = itemFactory.createItem("Backstage passes to a TAFKAL80ETC concert", 5, 20);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(arrayWith(backstagePasses));

        assertEquals(backstagePasses.quality, 23);
    }

    @Test
    public void testBackstagePassLosesValueAfterSellByPasses() {
        ItemFactory itemFactory = new ItemFactory();
        Item backstagePasses = itemFactory.createItem("Backstage passes to a TAFKAL80ETC concert", 0, 20);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(arrayWith(backstagePasses));

        assertEquals(backstagePasses.quality, 0);
    }
}
