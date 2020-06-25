package simplified.fractions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class SimplifiedFractions {
    public List<String> simplifiedFractions(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (gcd(i, j) > 1) {
                    continue;
                }
                result.add(i + "/" + j);
            }
        }
        return result;
    }

    private int gcd(int i, int j) {
        if (j != 0) {
            return gcd(j, i % j);
        }
        return i;
    }
}
