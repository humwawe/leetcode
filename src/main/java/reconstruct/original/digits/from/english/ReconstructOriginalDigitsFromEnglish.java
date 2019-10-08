package reconstruct.original.digits.from.english;

import java.sql.ResultSet;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author hum
 */
public class ReconstructOriginalDigitsFromEnglish {
    public String originalDigits(String s) {
        int[] alp = new int[26];
        for (char c : s.toCharArray()) {
            alp[c - 'a']++;
        }
        int[] result = new int[10];
        StringBuilder stringBuilder = new StringBuilder();
        String[] strings = new String[]{"zero", "eight", "six", "seven", "two", "three", "five", "four", "one", "nine"};

        int[] indexs = new int[]{0, 8, 6, 7, 2, 3, 5, 4, 1, 9};

        for (int i = 0; i < strings.length; i++) {
            String string = strings[i];
            int count = 50005;
            for (char c : string.toCharArray()) {
                count = Math.min(alp[c - 'a'], count);
            }
            for (char c : string.toCharArray()) {
                alp[c - 'a'] -= count;
            }
            result[indexs[i]] += count;
        }
        for (int i = 0; i < 10; i++) {
            int count = result[i];
            while (count != 0) {
                stringBuilder.append(i);
                count--;
            }
        }
        return stringBuilder.toString();

    }
}
