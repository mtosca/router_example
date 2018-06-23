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

        String quantity = values[1].replace('Q', ' ').trim();
        return new Item(values[0], new Integer(quantity));
    }
}
