package number.of.ways.to.wear.different.hats.to.each.other;


import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class NumberOfWaysToWearDifferentHatsToEachOther {
    int mod = (int) 1e9 + 7;
    Integer[][] memo = new Integer[41][1 << 10];
    int end;

    public int numberWays(List<List<Integer>> hats) {
        List<List<Integer>> h = new ArrayList<>();
        for (int i = 0; i < 41; i++) {
            h.add(new ArrayList<>());
        }
        end = (1 << hats.size()) - 1;
        for (int i = 0; i < hats.size(); i++) {
            List<Integer> list = hats.get(i);
            for (Integer integer : list) {
                h.get(integer).add(i);
            }
        }
        return helper(h, 0, 0);
    }

    private int helper(List<List<Integer>> h, int i, int state) {
        if (i == h.size()) {
            if (state == end) {
                return 1;
            }
            return 0;

        }
        if (memo[i][state] != null) {
            return memo[i][state];
        }
        int res = helper(h, i + 1, state);
        List<Integer> list = h.get(i);
        for (Integer integer : list) {
            if ((state >> integer & 1) == 1) {
                continue;
            }
            res += helper(h, i + 1, state | 1 << integer);
            res %= mod;
        }
        return memo[i][state] = res % mod;
    }
}
