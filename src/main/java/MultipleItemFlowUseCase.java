public class MultipleItemFlowUseCase implements FlowUseCase {

    @Override
    public FlowResponse selectFlow() {
        return new CartFlow();
    }
}
