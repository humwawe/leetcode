package edit.distance;

/**
 * @author hum
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {

        int[][] result = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word2.length(); i++) {
            result[0][i] = i;
        }
        for (int i = 0; i <= word1.length(); i++) {
            result[i][0] = i;
        }
        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    result[i + 1][j + 1] = result[i][j];
                } else {
                    result[i + 1][j + 1] = Math.min(Math.min(result[i][j + 1], result[i + 1][j]), result[i][j]) + 1;
                }
            }
        }
        return result[word1.length()][word2.length()];
    }
}
