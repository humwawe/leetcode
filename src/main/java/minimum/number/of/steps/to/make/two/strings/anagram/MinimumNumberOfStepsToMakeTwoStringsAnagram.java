package minimum.number.of.steps.to.make.two.strings.anagram;

/**
 * @author hum
 */
public class MinimumNumberOfStepsToMakeTwoStringsAnagram {
    public int minSteps(String s, String t) {
        int[] tmp = new int[26];
        for (char c : s.toCharArray()) {
            tmp[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            if (tmp[c - 'a'] > 0) {
                tmp[c - 'a']--;
            }
        }
        int res = 0;
        for (int i = 0; i < 26; i++) {
            res += tmp[i];
        }
        return res;
    }
}
