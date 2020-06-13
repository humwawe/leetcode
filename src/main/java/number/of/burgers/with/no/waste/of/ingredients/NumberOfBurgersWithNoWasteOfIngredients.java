package number.of.burgers.with.no.waste.of.ingredients;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class NumberOfBurgersWithNoWasteOfIngredients {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> result = new ArrayList<>();
        if (tomatoSlices % 2 != 0) {
            return result;
        }
        int t = tomatoSlices / 2;
        int tmp1 = t - cheeseSlices;
        int tmp2 = cheeseSlices - tmp1;
        if (tmp1 < 0 || tmp2 < 0) {
            return result;
        }
        result.add(tmp1);
        result.add(tmp2);
        return result;
    }
}
