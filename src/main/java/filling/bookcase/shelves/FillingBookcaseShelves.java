package filling.bookcase.shelves;


/**
 * @author hum
 */
public class FillingBookcaseShelves {

    public int minHeightShelves(int[][] books, int shelfWidth) {
        int len = books.length;
        int[] dp = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            dp[i] = dp[i - 1] + books[i - 1][1];
            int w = books[i - 1][0];
            int max = books[i - 1][1];
            for (int j = i - 1; j > 0 && w + books[j - 1][0] <= shelfWidth; j--) {
                max = Math.max(max, books[j - 1][1]);
                dp[i] = Math.min(dp[i], dp[j - 1] + max);
                w += books[j - 1][0];
            }
        }
        return dp[len];
    }

}
