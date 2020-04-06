package bag.of.tokens;

import java.util.Arrays;

/**
 * @author hum
 */
public class BagOfTokens {
    public int bagOfTokensScore(int[] tokens, int p) {
        Arrays.sort(tokens);
        int len = tokens.length;
        int i = 0;
        int j = len - 1;
        int score = 0;
        int result = 0;
        while (i <= j) {
            while (i <= j && p >= tokens[i]) {
                p -= tokens[i];
                score += 1;
                i++;
            }
            result = Math.max(result, score);
            if (i <= j && score > 0) {
                p += tokens[j];
                score -= 1;
                j--;
            }
            if (score == 0 && p < tokens[i]) {
                break;
            }
        }
        return result;
    }
}
