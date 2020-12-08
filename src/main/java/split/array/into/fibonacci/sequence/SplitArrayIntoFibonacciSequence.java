package split.array.into.fibonacci.sequence;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class SplitArrayIntoFibonacciSequence {

    public List<Integer> splitIntoFibonacci(String s) {
        int len = s.length();
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < len; i++) {
            String s1 = s.substring(0, i);
            if (helper(s1)) {
                for (int j = i + 1; j < len; j++) {
                    String s2 = s.substring(i, j);
                    if (helper(s.substring(i, j))) {
                        List<Integer> res = new ArrayList<>();
                        if (check(s.substring(j), Integer.valueOf(s1), Integer.valueOf(s2), res)) {
                            result.add(Integer.valueOf(s1));
                            result.add(Integer.valueOf(s2));
                            result.addAll(res);
                            return result;
                        }
                    }
                }
            }
        }
        return result;
    }

    private boolean check(String s, Integer i, Integer j, List<Integer> res) {
        if (s.isEmpty()) {
            return true;
        }
        long next = i + j;
        if (next < Integer.MAX_VALUE) {
            if (s.startsWith(String.valueOf(next))) {
                res.add((int) next);
                return check(s.substring(String.valueOf(next).length()), j, i + j, res);
            }
        }
        return false;
    }


    private boolean helper(String s) {
        if (s.length() > 1 && s.charAt(0) == '0') {
            return false;
        }
        if (s.length() >= 11) {
            return false;
        }
        return Long.valueOf(s) <= Integer.MAX_VALUE;
    }
}
