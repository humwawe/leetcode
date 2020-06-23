package the.k.th.lexicographical.string.of.all.happy.strings.of.length.n;

/**
 * @author hum
 */
public class TheKthLexicographicalStringOfAllHappyStringsOfLengthN {
    String result;
    int count;

    public String getHappyString(int n, int k) {
        count = 0;
        helper(n, 0, k, -1, "");
        return result;
    }

    private boolean helper(int n, int i, int k, int prev, String path) {
        if (i == n) {
            count++;
            System.out.println(path);
            if (count == k) {
                result = path;
                return true;
            }
            return false;
        }
        for (int j = 0; j < 3; j++) {
            if (prev == j) {
                continue;
            }
            if (helper(n, i + 1, k, j, path + String.valueOf((char) ('a' + j)))) {
                return true;
            }
        }
        return false;
    }
}
