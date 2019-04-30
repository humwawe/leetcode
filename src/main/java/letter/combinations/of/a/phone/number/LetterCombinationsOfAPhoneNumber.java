package letter.combinations.of.a.phone.number;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        String[] transform = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        if (digits.length() < 1) {
            return new ArrayList<>();
        }
        return helper(digits, transform);
    }

    public List<String> helper(String digits, String[] transform) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 1) {
            for (char d : transform[digits.charAt(0) - '0'].toCharArray()) {
                result.add(Character.toString(d));
            }
            return result;
        }
        String str = transform[digits.charAt(0) - '0'];
        for (int i = 0; i < str.length(); i++) {
            for (String subString : helper(digits.substring(1), transform)) {
                result.add(Character.toString(str.charAt(i)) + subString);
            }

        }
        return result;

    }

}
