public class SingleItemFlowUseCase implements FlowUseCase {

    @Override
    public FlowResponse selectFlow() {
        return new DirectFlow();
    }
}
