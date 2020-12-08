package video.stitching;

import java.util.Arrays;

/**
 * @author hum
 */
public class VideoStitching {

    public int videoStitching(int[][] clips, int t) {
        int len = clips.length;
        int[] dp = new int[t + 1];
        Arrays.fill(dp, 0x3f3f3f3f);
        dp[0] = 0;
        int start = 0;
        while (start < t) {
            int end = start;
            for (int i = 1; i <= len; i++) {
                int x = clips[i - 1][0];
                int y = clips[i - 1][1];
                if (x <= end) {
                    if (y > end) {
                        dp[Math.min(y, t)] = Math.min(dp[Math.min(y, t)], dp[end] + 1);
                    }
                    start = Math.max(start, y);
                }
            }
            if (start == end) {
                return -1;
            }
            start = end;
        }
        return dp[t];
    }
}
