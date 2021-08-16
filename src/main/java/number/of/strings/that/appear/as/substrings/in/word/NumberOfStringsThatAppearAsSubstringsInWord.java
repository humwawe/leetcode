package number.of.strings.that.appear.as.substrings.in.word;

/**
 * @author hum
 */
public class NumberOfStringsThatAppearAsSubstringsInWord {
    public int numOfStrings(String[] patterns, String word) {
        int res = 0;
        for (String pattern : patterns) {
            if (word.contains(pattern)) {
                res++;
            }
        }
        return res;
    }
}
