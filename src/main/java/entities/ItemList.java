package entities;

import usecases.Scenario;

import java.util.List;

public class ItemList {

    List<Item> items;

    public ItemList(List<Item> items) {
        this.items = items;
    }

    public Scenario createFlowUseCase() {

        if (items.size() > 1) return new MultipleItemScenario();

        Item item = items.get(0);

        return item.createScenario();
    }
}
