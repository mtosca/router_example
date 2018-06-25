package usecases;

import boundaries.FlowResponse;

public class UseCaseInteractor {

    public UseCaseInteractor() {
    }

    public FlowResponse execute(Scenario scenario) {
        return scenario.selectFlow();
    }
}
