package first.day.where.you.have.been.in.all.the.rooms;

/**
 * @author hum
 */
public class FirstDayWhereYouHaveBeenInAllTheRooms {
    public int firstDayBeenInAllRooms(int[] nextVisit) {
        int len = nextVisit.length;
        long[] dp = new long[len];
        dp[0] = 0;
        int mod = 1000000007;
        for (int i = 1; i < len; i++) {
            dp[i] = (mod + dp[i - 1] + 1 + (dp[i - 1] - dp[nextVisit[i - 1]]) + 1) % mod;
        }
        return (int) dp[len - 1];
    }

}
