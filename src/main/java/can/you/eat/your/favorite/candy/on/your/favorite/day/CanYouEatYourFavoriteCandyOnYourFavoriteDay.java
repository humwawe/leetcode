package can.you.eat.your.favorite.candy.on.your.favorite.day;

/**
 * @author hum
 */
public class CanYouEatYourFavoriteCandyOnYourFavoriteDay {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        int len = candiesCount.length;
        long[] sum = new long[len + 1];
        for (int i = 0; i < len; i++) {
            sum[i + 1] = sum[i] + candiesCount[i];
        }
        boolean[] res = new boolean[queries.length];
        for (int i = 0, queriesLength = queries.length; i < queriesLength; i++) {
            int[] query = queries[i];
            int type = query[0];
            int day = query[1];
            long limit = query[2];
            int min = day + 1;
            long max = limit * (day + 1);
            res[i] = min <= sum[type + 1] && max > sum[type];
        }
        return res;
    }
}
