package reverse.words.in.a.string;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author hum
 */
public class ReverseWordsInAString {
    public String reverseWords(String s) {
        String[] strings = s.trim().split("\\s+");
        Collections.reverse(Arrays.asList(strings));
        return String.join(" ", strings);
    }
}
