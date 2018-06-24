public class SingleItemMultipleQuantityFlowUseCase implements FlowUseCase {

    //private final ShippingGateway shippingGateway;

    @Override
    public FlowResponse selectFlow() {

        //this.shippingGateway = new ShippingGatewayAPIClient();

        return new DirectFlow();
    }
}
