package tv.codely.kata.gildedrose.domain;

public class ItemName {
    private String name;

    public ItemName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemName itemName = (ItemName) o;

        return name != null ? name.equals(itemName.name) : itemName.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "ItemName{" +
                "name='" + name + '\'' +
                '}';
    }
}
