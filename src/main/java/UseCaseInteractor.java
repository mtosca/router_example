public class UseCaseInteractor {

    public UseCaseInteractor() {
    }

    public CartFlow execute(MultipleItemFlowRequest multipleItemFlowRequest) {
        return new CartFlow();
    }

    public DirectFlow execute(SingleItemFlowRequest multipleItemFlowRequest) {
        return new DirectFlow();
    }
}
