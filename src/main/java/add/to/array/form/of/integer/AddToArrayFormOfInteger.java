package add.to.array.form.of.integer;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class AddToArrayFormOfInteger {
    public List<Integer> addToArrayForm(int[] a, int k) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i : a) {
            stringBuilder.append(i);
        }
        BigInteger bigInteger = new BigInteger(stringBuilder.toString());
        BigInteger res = bigInteger.add(BigInteger.valueOf(k));
        List<Integer> list = new ArrayList<>();
        for (char c : res.toString().toCharArray()) {
            list.add(c - '0');
        }
        return list;
    }
}
