package tv.codely.kata.gildedrose;

import tv.codely.kata.gildedrose.application.GildedRose;
import tv.codely.kata.gildedrose.domain.Item;
import tv.codely.kata.gildedrose.domain.ItemFactory;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GildedRoseCliEntryPoint {
    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        ItemFactory itemFactory = new ItemFactory();

        List<Item> items = Stream.of(
                itemFactory.createItem("+5 Dexterity Vest", 10, 20), //
                itemFactory.createItem("Aged Brie", 2, 0), //
                itemFactory.createItem("Elixir of the Mongoose", 5, 7), //
                itemFactory.createItem("Sulfuras, Hand of Ragnaros", 0, 80), //
                itemFactory.createItem("Sulfuras, Hand of Ragnaros", -1, 80),
                itemFactory.createItem("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                itemFactory.createItem("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                itemFactory.createItem("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                itemFactory.createItem("Conjured Mana Cake", 3, 6)
        ).collect(Collectors.toList());

        GildedRose app = new GildedRose();

        int days = 2;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (Item item : items) {
                System.out.println(item);
            }
            System.out.println();
            app.updateQuality(items);
        }
    }

}
