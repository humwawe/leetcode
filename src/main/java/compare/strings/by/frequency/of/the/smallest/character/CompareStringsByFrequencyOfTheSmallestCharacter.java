package compare.strings.by.frequency.of.the.smallest.character;

/**
 * @author hum
 */
public class CompareStringsByFrequencyOfTheSmallestCharacter {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] t = new int[11];
        for (String word : words) {
            t[helper(word)]++;
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int count = helper(queries[i]);
            int res = 0;
            for (int j = 10; j > count; j--) {
                result[i] += t[j];
            }
        }
        return result;
    }

    private int helper(String word) {
        int[] tmp = new int[26];
        for (char c : word.toCharArray()) {
            tmp[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (tmp[i] != 0) {
                return tmp[i];
            }
        }
        return -1;
    }
}
