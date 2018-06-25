import entities.Item;
import entities.ItemBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParameterParser {

    public List<Item> parse(String params) {

        String[] paramsList = params.split(",");

        return Arrays.asList(paramsList)
                .stream()
                .map((e) -> itemFromString(e))
                .collect(Collectors.toList());
    }

    private Item itemFromString(String itemString) {
        String[] values = itemString.split("-");

        String quantityStr = values[1].replace('Q', ' ').trim();

        return new ItemBuilder()
                .withId(values[0])
                .withQuantity(new Integer(quantityStr))
                .build();
    }
}
