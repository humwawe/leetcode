package shortest.completing.word;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author hum
 */
public class ShortestCompletingWord {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        licensePlate = licensePlate.toLowerCase();
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int[] target = new int[26];
        for (char c : licensePlate.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                target[c - 'a']++;
            }
        }
        for (String word : words) {
            int[] tmp = new int[26];
            for (char c : word.toCharArray()) {
                tmp[c - 'a']++;
            }
            boolean flag = true;
            for (int i = 0; i < 26; i++) {
                if (tmp[i] < target[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return word;
            }
        }
        return "";
    }
}
