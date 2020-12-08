package maximum.of.absolute.value.expression;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author hum
 */
public class MaximumOfAbsoluteValueExpression {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        List<Integer> c = new ArrayList<>();
        List<Integer> d = new ArrayList<>();
        int n = arr1.length;
        for (int i = 0; i < n; i++) {
            a.add(arr1[i] + arr2[i] + i);
            b.add(arr1[i] + arr2[i] - i);
            c.add(arr1[i] - arr2[i] + i);
            d.add(arr1[i] - arr2[i] - i);
        }
        Collections.sort(a);
        Collections.sort(b);
        Collections.sort(c);
        Collections.sort(d);
        return Math.max(Math.max(a.get(n - 1) - a.get(0), b.get(n - 1) - b.get(0)), Math.max(c.get(n - 1) - c.get(0), d.get(n - 1) - d.get(0)));
    }
}
