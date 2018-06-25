package entities;

import boundaries.FlowResponse;
import usecases.Scenario;

public class SingleItemMultipleQuantityScenario implements Scenario {

    //private final ShippingGateway shippingGateway;

    @Override
    public FlowResponse selectFlow() {

        //this.shippingGateway = new ShippingGatewayAPIClient();

        return new DirectFlow();
    }
}
