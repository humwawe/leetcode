package count.the.repetitions;

/**
 * @author hum
 */
public class CountTheRepetitions {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int[] repeatCnt = new int[n1 + 1];
        int[] nextIdx = new int[n1 + 1];
        int j = 0, cnt = 0;
        for (int k = 1; k <= n1; ++k) {
            for (int i = 0; i < s1.length(); ++i) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    ++j;
                    if (j == s2.length()) {
                        j = 0;
                        ++cnt;
                    }
                }
            }
            repeatCnt[k] = cnt;
            nextIdx[k] = j;
            for (int start = 0; start < k; ++start) {
                if (nextIdx[start] == j) {
                    int interval = k - start;
                    int repeat = (n1 - start) / interval;
                    int patternCnt = (repeatCnt[k] - repeatCnt[start]) * repeat;
                    int remainCnt = repeatCnt[start + (n1 - start) % interval];
                    return (patternCnt + remainCnt) / n2;
                }
            }
        }
        return repeatCnt[n1] / n2;
    }

    private int helper(String s1, int n1, String s2, int n2) {
        int num1 = 0, num2 = 0, j = 0;
        while (num1 < n1) {
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    if (j == s2.length() - 1) {
                        j = 0;
                        num2++;
                    } else {
                        j++;
                    }
                }
            }
            num1++;
        }
        return num2 / n2;
    }
}
