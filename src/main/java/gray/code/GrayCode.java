package gray.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class GrayCode {
    public List<Integer> grayCode(int n) {
        if (n == 0) {
            List<Integer> result = new ArrayList<>();
            result.add(0);
            return result;
        }

        List<Integer> result = grayCode(n - 1);
        List<Integer> newResult = new ArrayList<>(result);
        int tmp = 1 << n - 1;
        for (int i = result.size() - 1; i >= 0; i--) {
            newResult.add(tmp + result.get(i));
        }
        return newResult;
    }
}
