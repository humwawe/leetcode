package unique.binary.search.trees;

/**
 * @author hum
 */
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        if (n <= 1) {
            return 1;
        }
        int[] result = new int[n + 1];
        result[0] = 1;
        result[1] = 1;
        for (int i = 2; i <= n; i++) {
            result[i] = 0;
            for (int j = 1; j <= i; j++) {
                result[i] += result[j - 1] + result[i - j - 1];
            }
        }
        return result[n];
    }

}
