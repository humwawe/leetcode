package minimum.cost.to.set.cooking.time;

/**
 * @author hum
 */
public class MinimumCostToSetCookingTime {
    public int minCostSetTime(int start, int move, int push, int t) {
        int min1 = t / 60;
        int sec1 = t % 60;
        int ans1 = helper(start, move, push, min1, sec1);
        int min2 = min1 - 1;
        int sec2 = sec1 + 60;
        int ans2 = helper(start, move, push, min2, sec2);
        return Math.min(ans1, ans2);
    }

    public int helper(int start, int move, int push, int min, int sec) {
        if (min > 99 || min < 0 || sec > 99) {
            return Integer.MAX_VALUE;
        }
        int res = 0;
        int[] t = new int[4];
        t[0] = min / 10;
        t[1] = min % 10;
        t[2] = sec / 10;
        t[3] = sec % 10;
        int k = 0;
        while (t[k] == 0) {
            k++;
        }
        int now = start;
        while (k < 4) {
            if (t[k] == now) {
                res += push;
            } else {
                res += push + move;
                now = t[k];
            }
            k++;
        }
        return res;
    }

}
