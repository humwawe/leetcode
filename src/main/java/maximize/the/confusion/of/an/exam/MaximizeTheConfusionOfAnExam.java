package maximize.the.confusion.of.an.exam;

/**
 * @author hum
 */
public class MaximizeTheConfusionOfAnExam {
    String answerKey;
    int len, k;
    int res = 0;

    public int maxConsecutiveAnswers(String answerKey, int k) {
        len = answerKey.length();
        this.k = k;
        this.answerKey = answerKey;
        helper('T', 'F');
        helper('F', 'T');
        return res;

    }

    private void helper(char t, char f) {
        int j = 0;
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            while (j < len) {
                if (answerKey.charAt(j) == t) {
                    j++;
                } else if (cnt < k) {
                    cnt++;
                    j++;
                } else {
                    break;
                }
            }
            res = Math.max(res, j - i);
            if (answerKey.charAt(i) == f) {
                cnt--;
            }
        }
    }
}
