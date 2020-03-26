package beautiful.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class BeautifulArray {
    public int[] beautifulArray(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(1);
        while (result.size() < n) {
            List<Integer> tmp = new ArrayList<>();
            for (Integer a : result) {
                if (a * 2 - 1 <= n) {
                    tmp.add(a * 2 - 1);
                }
            }
            for (Integer a : result) {
                if (a * 2 <= n) {
                    tmp.add(a * 2);
                }
            }
            result = tmp;
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}
