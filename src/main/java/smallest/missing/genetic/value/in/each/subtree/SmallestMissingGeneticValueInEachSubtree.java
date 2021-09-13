package smallest.missing.genetic.value.in.each.subtree;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author hum
 */
public class SmallestMissingGeneticValueInEachSubtree {
    int N = 100010;
    int[] h = new int[N];
    int[] e = new int[N];
    int[] ne = new int[N];
    int idx;
    int[] res;
    int[] nums;

    public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
        Arrays.fill(h, -1);
        idx = 0;
        for (int i = 1; i < parents.length; i++) {
            addE(parents[i], i);
        }
        res = new int[parents.length];
        this.nums = nums;
        dfs(0);
        return res;
    }

    class Ret {
        Set<Integer> set = new HashSet<>();
        int mex;

        public Ret(Set<Integer> set, int mex) {
            this.set = set;
            this.mex = mex;
        }
    }

    private Ret dfs(int u) {
        Set<Integer> cur = new HashSet<>();
        cur.add(nums[u]);
        int mex = 1;
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            Ret child = dfs(j);
            if (child.set.size() > cur.size()) {
                Set<Integer> tmp = child.set;
                child.set = cur;
                cur = tmp;
            }
            cur.addAll(child.set);
            mex = Math.max(mex, child.mex);
        }
        while (cur.contains(mex)) {
            mex++;
        }
        res[u] = mex;
        return new Ret(cur, mex);
    }

    void addE(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

}
