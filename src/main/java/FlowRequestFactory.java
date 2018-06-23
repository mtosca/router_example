import java.util.List;

public class FlowRequestFactory {

    public FlowRequest create(List<Item> itemList) {

        if (itemList.size() > 1) return new MultipleItemFlowRequest();

        Item item = itemList.get(0);

        // @smell no queremos métodos del tipo isABC()
        return item.isMultipleQuantity() ? new SingleItemMultipleQuantityFlowRequest() : new SingleItemFlowRequest();
    }
}
