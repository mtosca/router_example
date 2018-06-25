package entities;

import boundaries.FlowResponse;
import usecases.Scenario;

public class SingleItemScenario implements Scenario {

    @Override
    public FlowResponse selectFlow() {
        return new DirectFlow();
    }
}
