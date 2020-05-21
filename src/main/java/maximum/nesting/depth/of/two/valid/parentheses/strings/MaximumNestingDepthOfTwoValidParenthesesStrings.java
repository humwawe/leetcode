package maximum.nesting.depth.of.two.valid.parentheses.strings;

/**
 * @author hum
 */
public class MaximumNestingDepthOfTwoValidParenthesesStrings {
    public int[] maxDepthAfterSplit(String seq) {
        int count = 0;
        int[] result = new int[seq.length()];
        for (int i = 0; i < seq.length(); i++) {
            char c = seq.charAt(i);
            if (c == '(') {
                count++;
                result[i] = count % 2;
            } else {
                result[i] = count % 2;
                count--;
            }
        }
        return result;
    }
}
