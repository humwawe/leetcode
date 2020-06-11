package maximum.score.words.formed.by.letters;

/**
 * @author hum
 */
public class MaximumScoreWordsFormedByLetters {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int len = words.length;
        int[] s = new int[len];
        int[][] t = new int[len][26];
        for (int i = 0; i < len; i++) {
            for (char c : words[i].toCharArray()) {
                s[i] += score[c - 'a'];
                t[i][c - 'a']++;
            }
        }
        int[] count = new int[26];
        for (char letter : letters) {
            count[letter - 'a']++;
        }
        return helper(t, s, 0, count);
    }

    private int helper(int[][] t, int[] s, int i, int[] count) {
        if (i == s.length) {
            return 0;
        }
        int res = helper(t, s, i + 1, count);
        boolean f = true;
        for (int j = 0; j < 26; j++) {
            if (t[i][j] > count[j]) {
                f = false;
            }
        }
        if (f) {
            int[] tmp = new int[26];
            for (int j = 0; j < 26; j++) {
                tmp[j] = count[j] - t[i][j];
            }
            res = Math.max(res, helper(t, s, i + 1, tmp) + s[i]);
        }
        return res;
    }
}
