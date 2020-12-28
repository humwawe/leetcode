package maximum.xor.with.an.element.from.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author hum
 */
public class MaximumXorWithAnElementFromArray {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        int len = queries.length;
        Integer[] idx = new Integer[len];
        for (int i = 0; i < len; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, Comparator.comparingInt(x -> queries[x][1]));
        int[] res = new int[len];
        Trie trie = new Trie(len * 32 + 10);
        int j = 0;
        for (int i = 0; i < len; i++) {
            int[] q = queries[idx[i]];
            while (j < nums.length && nums[j] <= q[1]) {
                trie.insert(nums[j]);
                j++;
            }
            if (j == 0) {
                res[idx[i]] = -1;
            } else {
                res[idx[i]] = trie.query(q[0]) ^ q[0];
            }
        }
        return res;
    }

    class Trie {
        int n;
        int[][] son;
        int[] cnt;
        int idx;

        public Trie(int n) {
            this.n = n;
            son = new int[n][2];
            cnt = new int[n];
            idx = 0;
        }

        void insert(int num) {
            int p = 0;
            for (int i = 31; i >= 0; i--) {
                int u = (num >> i & 1);
                if (son[p][u] == 0) {
                    son[p][u] = ++idx;
                }
                p = son[p][u];
            }
            cnt[p] = num;
        }

        // 查询字符串出现的次数
        int query(int num) {
            int p = 0;
            for (int i = 31; i >= 0; i--) {
                int u = (num >> i & 1);
                if (son[p][u ^ 1] != 0) {
                    p = son[p][u ^ 1];
                } else {
                    p = son[p][u];
                }
            }
            return cnt[p];
        }
    }
}
