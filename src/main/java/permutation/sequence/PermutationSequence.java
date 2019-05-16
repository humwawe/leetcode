package permutation.sequence;

/**
 * @author hum
 */
public class PermutationSequence {
    private int count = 0;

    public String getPermutation(int n, int k) {
        boolean[] used = new boolean[n + 1];
        StringBuilder result = new StringBuilder();
        helper(0, n, k, result, used);
        return result.toString();

    }

    private boolean helper(int level, int n, int k, StringBuilder result, boolean[] used) {
        if (level == n) {
            return ++count == k;
        }

        for (int i = 1; i <= n; i++) {
            if (!used[i]) {
                result.append(i);
                used[i] = true;
                if (helper(level + 1, n, k, result, used)) {
                    return true;
                }
                used[i] = false;
                result.deleteCharAt(result.length() - 1);
            }
        }
        return false;


    }


}
