import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Tests for the dojo.
 */
public class DojoTest {

    @Before
    public void setup() {

    }

    @Test
    public void build_item_from_param_string() {
        String params = "MLA123456-Q1";

        ParameterParser parameterParser = new ParameterParser();
        List<Item> items = parameterParser.parse(params);

        Assert.assertEquals(new Item("MLA123456", 1), items.get(0));
    }

    @Test
    public void build_item_list_from_param_string() {
        String params = "MLA123456-Q1,MLA234567-Q2";

        ParameterParser parameterParser = new ParameterParser();
        List<Item> items = parameterParser.parse(params);

        Assert.assertEquals(new Item("MLA123456", 1), items.get(0));
        Assert.assertEquals(new Item("MLA234567", 2), items.get(1));
    }


    @Test
    public void create_flow_request_from_one_item() {

        List<Item> items = new ArrayList<>();
        items.add(new Item("MLA12345", 1));

        FlowRequestFactory flowRequestBuilder = new FlowRequestFactory();
        FlowRequest flowRequest = flowRequestBuilder.create(items);

        Assert.assertTrue(flowRequest instanceof SingleItemFlowRequest);
    }

    @Test
    public void create_flow_request_from_one_item_multiple_quantity() {

        List<Item> items = new ArrayList<>();
        items.add(new Item("MLA12345", 5));

        FlowRequestFactory flowRequestBuilder = new FlowRequestFactory();
        FlowRequest flowRequest = flowRequestBuilder.create(items);

        Assert.assertTrue(flowRequest instanceof SingleItemMultipleQuantityFlowRequest);
    }

    @Test
    public void create_flow_request_from_multiple_item() {

        List<Item> items = new ArrayList<>();
        items.add(new Item("MLA12345", 1));
        items.add(new Item("MLA23456", 1));

        FlowRequestFactory flowRequestBuilder = new FlowRequestFactory();
        FlowRequest flowRequest = flowRequestBuilder.create(items);

        Assert.assertTrue(flowRequest instanceof MultipleItemFlowRequest);
    }

    @Test
    public void test_one_item_and_quantity_one_should_goto_direct() {

        UseCaseInteractor useCaseInteractor = new UseCaseInteractor();

        Assert.assertEquals(useCaseInteractor.execute(new SingleItemFlowRequest()), new DirectFlow());
    }

    @Test
    public void test_multiple_item_should_goto_cart() {

        UseCaseInteractor useCaseInteractor = new UseCaseInteractor();

        Assert.assertEquals(useCaseInteractor.execute(new MultipleItemFlowRequest()), new CartFlow());
    }
}
