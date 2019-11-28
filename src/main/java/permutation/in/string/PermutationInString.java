package permutation.in.string;

import java.util.Arrays;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] c1 = new int[26];
        int[] c2 = new int[26];
        for (char c : s1.toCharArray()) {
            c1[c - 'a']++;
        }
        int count = 0;
        int len = s1.length();
        for (int i = 0; i < len; i++) {
            c2[s2.charAt(i) - 'a']++;
        }
        if (helper(c1, c2)) {
            return true;
        }
        int index = len + 1;
        while (index < s2.length()) {
            c2[s2.charAt(index) - 'a']++;
            c2[s2.charAt(index - len) - 'a']--;
            if (helper(c1, c2)) {
                return true;
            }
            index++;
        }
        return false;
    }

    private boolean helper(int[] c1, int[] c2) {
        for (int i = 0; i < 26; i++) {
            if (c1[i] != c2[i]) {
                return false;
            }
        }
        return true;
    }
}
