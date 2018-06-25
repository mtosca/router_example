package entities;

public class ItemBuilder {

    private String id;
    private Integer quantity;

    public ItemBuilder withId(String id) {
        this.id = id;
        return this;
    }

    public ItemBuilder withQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public Item build() {
        return this.quantity == 1 ? new SingleQuantityItem(this.id)
                : new MultipleQuantityItem(this.id, this.quantity);
    }
}
