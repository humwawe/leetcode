package search.suggestions.system;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hum
 */
public class SearchSuggestionsSystem {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        int len = searchWord.length();
        for (int i = 0; i < len; i++) {
            result.add(new ArrayList<>());
        }
        Arrays.sort(products);
        int start = 0;
        for (int i = 1; i <= len; i++) {
            String tmp = searchWord.substring(0, i);
            boolean f = false;
            for (int j = start; j < products.length; j++) {
                if (products[j].startsWith(tmp)) {
                    result.get(i - 1).add(products[j]);
                    f = true;
                } else if (f) {
                    break;
                }
                if (result.get(i - 1).size() == 3) {
                    break;
                }
                start = j - result.get(i - 1).size() + 1;
            }
        }
        return result;
    }
}
