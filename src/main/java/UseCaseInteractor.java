public class UseCaseInteractor {

    public UseCaseInteractor() {
    }

    public FlowResponse execute(MultipleItemFlowUseCase multipleItemFlowUseCase) {
        return multipleItemFlowUseCase.selectFlow();
    }

    public FlowResponse execute(SingleItemFlowUseCase singleItemFlowUseCase) {
        return singleItemFlowUseCase.selectFlow();
    }

    public FlowResponse execute(SingleItemMultipleQuantityFlowUseCase singleItemMultipleQuantityFlowUseCase) {
        return singleItemMultipleQuantityFlowUseCase.selectFlow();
    }
}
