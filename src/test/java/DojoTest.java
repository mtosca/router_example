import entities.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import usecases.Scenario;
import usecases.UseCaseInteractor;

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

        Assert.assertEquals(new SingleQuantityItem("MLA123456"), items.get(0));
    }

    @Test
    public void build_item_list_from_param_string() {
        String params = "MLA123456-Q1,MLA234567-Q2";

        ParameterParser parameterParser = new ParameterParser();
        List<Item> items = parameterParser.parse(params);

        Assert.assertEquals(new SingleQuantityItem("MLA123456"), items.get(0));
        Assert.assertEquals(new MultipleQuantityItem("MLA234567", 2), items.get(1));
    }

    @Test
    public void create_flow_request_from_one_item() {

        List<Item> items = new ArrayList<>();
        items.add(new SingleQuantityItem("MLA12345"));

        ItemList itemList = new ItemList(items);
        Scenario scenario = itemList.createFlowUseCase();

        Assert.assertTrue(scenario instanceof SingleItemScenario);
    }

    @Test
    public void create_flow_request_from_one_item_multiple_quantity() {

        List<Item> items = new ArrayList<>();
        items.add(new MultipleQuantityItem("MLA12345", 5));

        ItemList itemList = new ItemList(items);
        Scenario scenario = itemList.createFlowUseCase();

        Assert.assertTrue(scenario instanceof SingleItemMultipleQuantityScenario);
    }

    @Test
    public void create_flow_request_from_multiple_item() {

        List<Item> items = new ArrayList<>();
        items.add(new SingleQuantityItem("MLA12345"));
        items.add(new SingleQuantityItem("MLA23456"));

        ItemList itemList = new ItemList(items);
        Scenario scenario = itemList.createFlowUseCase();

        Assert.assertTrue(scenario instanceof MultipleItemScenario);
    }

    @Test
    public void test_one_item_and_quantity_one_should_goto_direct() {

        UseCaseInteractor useCaseInteractor = new UseCaseInteractor();

        Assert.assertEquals(useCaseInteractor.execute(new SingleItemScenario()), new DirectFlow());
    }

    @Test
    public void test_one_item_and_quantity_many_should_goto_direct() {

        UseCaseInteractor useCaseInteractor = new UseCaseInteractor();

        Assert.assertEquals(useCaseInteractor.execute(new SingleItemMultipleQuantityScenario()), new DirectFlow());
    }

    @Test
    public void test_multiple_item_should_goto_cart() {

        UseCaseInteractor useCaseInteractor = new UseCaseInteractor();

        Assert.assertEquals(useCaseInteractor.execute(new MultipleItemScenario()), new CartFlow());
    }
}
