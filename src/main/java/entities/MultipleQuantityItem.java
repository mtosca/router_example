package entities;

import usecases.Scenario;

import java.util.Objects;

public class MultipleQuantityItem implements Item {

    private final String id;
    private final Integer quantity;

    public MultipleQuantityItem(String id, Integer quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    @Override
    public Scenario createScenario() {
        return new SingleItemMultipleQuantityScenario();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MultipleQuantityItem item = (MultipleQuantityItem) o;
        return Objects.equals(id, item.id) &&
                Objects.equals(quantity, item.quantity);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, quantity);
    }

}
