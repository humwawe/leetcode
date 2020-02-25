package loud.and.rich;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hum
 */
public class LoudAndRich {
    int[] memo;

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int len = quiet.length;
        List<Nod> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            list.add(new Nod(i, quiet[i]));
        }
        for (int[] ints : richer) {
            list.get(ints[1]).child.add(list.get(ints[0]));
        }
        memo = new int[len];
        Arrays.fill(memo, -1);
        for (int i = 0; i < len; i++) {
            if (memo[i] == -1) {
                helper(list.get(i), list);
            }
        }
        return memo;
    }

    private int helper(Nod root, List<Nod> list) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        if (memo[root.num] != -1) {
            return memo[root.num];
        }
        int min = root.quiet;
        int res = root.num;
        for (Nod nod : root.child) {
            int n = helper(nod, list);
            int tmp = list.get(n).quiet;
            if (tmp < min) {
                min = tmp;
                res = n;
            }
        }
        return memo[root.num] = res;
    }

    class Nod {
        int num;
        int quiet;
        List<Nod> child;

        public Nod(int n, int quiet) {
            this.num = n;
            this.quiet = quiet;
            child = new ArrayList<>();
        }
    }
}
