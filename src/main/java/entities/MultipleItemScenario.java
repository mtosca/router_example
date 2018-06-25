package entities;

import boundaries.FlowResponse;
import usecases.Scenario;

public class MultipleItemScenario implements Scenario {

    @Override
    public FlowResponse selectFlow() {
        return new CartFlow();
    }
}
