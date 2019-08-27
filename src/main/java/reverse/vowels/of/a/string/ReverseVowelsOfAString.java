package reverse.vowels.of.a.string;

import java.util.Arrays;

/**
 * @author hum
 */
public class ReverseVowelsOfAString {
    char[] vowels = new char[]{'a', 'e', 'o', 'u', 'i'};

    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        int j = chars.length - 1;

        for (char c : chars) {
            if (isVowel(c)) {
                while (!isVowel(chars[j])) {
                    j--;
                }
                stringBuilder.append(chars[j]);
                j--;
            } else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

    private boolean isVowel(char c) {
        for (char vowel : vowels) {
            if (Character.toLowerCase(c) == vowel) {
                return true;
            }
        }
        return false;
    }
}
