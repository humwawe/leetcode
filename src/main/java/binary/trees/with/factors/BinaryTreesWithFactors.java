package binary.trees.with.factors;

import java.util.*;

/**
 * @author hum
 */
public class BinaryTreesWithFactors {
    Map<Integer, Long> memo = new HashMap<>();
    Set<Integer> set = new HashSet<>();

    public int numFactoredBinaryTrees(int[] arr) {
        for (int i : arr) {
            set.add(i);
        }
        for (int i : arr) {
            helper(i);
        }
        long result = 0;
        for (int i : arr) {
            result += memo.get(i);
        }
        System.out.println(memo);
        int mod = 1000000007;
        return (int) (result % mod);
    }

    private long helper(int num) {
        if (memo.containsKey(num)) {
            return memo.get(num);
        }
        if (!set.contains(num)) {
            return 0;
        }
        long res = 1;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0 && num / i > 1) {
                long l = helper(i);
                long r = helper(num / i);
                if (l != 0 && r != 0) {
                    long tmp = l * r;
                    res += tmp;
                    if (i != num / i) {
                        res += tmp;
                    }
                }
            }
        }
        memo.put(num, res);
        return res;
    }
}
