package create.sorted.array.through.instructions;

/**
 * @author hum
 */
public class CreateSortedArrayThroughInstructions {
    public int createSortedArray(int[] instructions) {
        long res = 0;
        int mod = (int) (1e9 + 7);
        for (int i = 0; i < instructions.length; i++) {
            int l = sum(instructions[i] - 1);
            int r = sum(instructions[i]);
            res += Math.min(l, i - r);
            add(instructions[i], 1);
        }
        return (int) (res % mod);
    }

    int N = (int) (1e5 + 5);
    int[] t = new int[N];
    int n = N;

    int lowbit(int x) {
        return x & -x;
    }

    void add(int x, int c) {
        for (int i = x; i <= n; i += lowbit(i)) {
            t[i] += c;
        }
    }

    int sum(int x) {
        int res = 0;
        for (int i = x; i > 0; i -= lowbit(i)) {
            res += t[i];
        }
        return res;
    }
}
