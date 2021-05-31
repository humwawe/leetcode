package check.word.equals.summation.of.two.words;

/**
 * @author hum
 */
public class CheckIfWordEqualsSummationOfTwoWords {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        int a = helper(firstWord);
        int b = helper(secondWord);
        int c = helper(targetWord);
        return a + b == c;
    }

    private int helper(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res = res * 10 + (s.charAt(i) - 'a');
        }
        return res;
    }
}
