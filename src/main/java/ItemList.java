import java.util.List;

public class ItemList {

    List<Item> items;

    public ItemList(List<Item> items) {
        this.items = items;
    }

    public FlowUseCase createFlowUseCase() {

        if (items.size() > 1) return new MultipleItemFlowUseCase();

        Item item = items.get(0);

        return item.createFlowUseCase();
    }
}
