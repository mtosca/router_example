package entities;

import boundaries.FlowResponse;

public class DirectFlow implements FlowResponse {

    public DirectFlow() {
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof DirectFlow;
    }
}
