package change.minimum.characters.to.satisfy.one.of.three.conditions;

/**
 * @author hum
 */
public class ChangeMinimumCharactersToSatisfyOneOfThreeConditions {
    public int minCharacters(String a, String b) {
        int[] cntA = new int[26];
        int[] cntB = new int[26];
        for (char c : a.toCharArray()) {
            cntA[c - 'a']++;
        }
        for (char c : b.toCharArray()) {
            cntB[c - 'a']++;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < 26; i++) {
            res = Math.min(res, helper(cntA, cntB, i));
            res = Math.min(res, helper(cntB, cntA, i));
        }
        for (int i = 0; i < 26; i++) {
            res = Math.min(res, helper2(cntA, cntB, i));
        }
        return res;
    }

    private int helper2(int[] cntA, int[] cntB, int i) {
        int res = 0;
        for (int j = 0; j < 26; j++) {
            if (j != i) {
                res += cntA[j];
                res += cntB[j];
            }
        }
        return res;
    }

    private int helper(int[] cntA, int[] cntB, int i) {
        int res = 0;
        for (int j = 0; j < 26; j++) {
            if (j >= i) {
                res += cntA[j];
            }
            if (j < i) {
                res += cntB[j];
            }
        }
        return res;
    }
}
