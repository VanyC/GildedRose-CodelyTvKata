package tv.codely.kata.gildedrose;

import java.util.List;

class GildedRose {

    public void updateQuality(List<Item> items) {
        items.forEach(Item::update);
    }
}
