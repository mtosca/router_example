package entities;

import boundaries.FlowResponse;

public class CartFlow implements FlowResponse {

    public CartFlow() {
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof CartFlow;
    }
}
