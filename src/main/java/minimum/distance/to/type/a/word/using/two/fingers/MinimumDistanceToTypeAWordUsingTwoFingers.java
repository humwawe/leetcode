package minimum.distance.to.type.a.word.using.two.fingers;

/**
 * @author hum
 */
public class MinimumDistanceToTypeAWordUsingTwoFingers {
    Integer[][][] memo;
    int len;

    public int minimumDistance(String word) {
        len = word.length();
        memo = new Integer[len][27][28];
        return helper(word, 1, word.charAt(0) - 'A', 27);
    }

    private int helper(String word, int i, int a, int b) {
        if (i == word.length()) {
            return 0;
        }
        if (memo[i][a][b] != null) {
            return memo[i][a][b];
        }
        int now = word.charAt(i) - 'A';
        int len1 = getLen(a, now);
        int len2 = getLen(b, now);
        return memo[i][a][b] = Math.min(len1 + helper(word, i + 1, now, b), len2 + helper(word, i + 1, a, now));
    }

    private int getLen(int a, int b) {
        if (a == 27) {
            return 0;
        }
        int[] point = getPoint(a);
        int[] point2 = getPoint(b);
        return Math.abs(point[0] - point2[0]) + Math.abs(point[1] - point2[1]);
    }

    private int[] getPoint(int x) {
        return new int[]{x / 6, x % 6};
    }
}
