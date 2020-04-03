package tv.codely.kata.gildedrose.domain;

public class ItemQualityOutOfRangeException extends RuntimeException {

    public ItemQualityOutOfRangeException(String errorMessage) {
        super(errorMessage);
    }
}
