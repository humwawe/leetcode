package reverse.words.in.a.string.III;

import java.util.Arrays;
import java.util.Collections;

public class ReverseWordsInAStringIII {
    public String reverseWords(String s) {
        StringBuilder reverse = new StringBuilder(s).reverse();
        String[] strings = reverse.toString().split("\\s+");
        Collections.reverse(Arrays.asList(strings));
        return String.join(" ", strings);
    }
}
