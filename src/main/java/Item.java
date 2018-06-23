import java.util.Objects;

public class Item {

    private final String id;
    private final Integer quantity;

    public Item(String id, Integer quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public boolean isMultipleQuantity() {
        return this.quantity > 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(id, item.id) &&
                Objects.equals(quantity, item.quantity);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, quantity);
    }
}
