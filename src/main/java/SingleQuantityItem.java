import java.util.Objects;

public class SingleQuantityItem implements Item {

    private final String id;
    private final Integer quantity;

    public SingleQuantityItem(String id) {
        this.id = id;
        this.quantity = 1;
    }

    @Override
    public FlowUseCase createFlowUseCase() {
        return new SingleItemFlowUseCase();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SingleQuantityItem item = (SingleQuantityItem) o;
        return Objects.equals(id, item.id) &&
                Objects.equals(quantity, item.quantity);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, quantity);
    }
}
