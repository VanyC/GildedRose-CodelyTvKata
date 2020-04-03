package tv.codely.kata.gildedrose.application;

import tv.codely.kata.gildedrose.domain.Item;

import java.util.List;

public class GildedRose {

    public void updateQuality(List<Item> items) {
        items.forEach(Item::update);
    }
}
