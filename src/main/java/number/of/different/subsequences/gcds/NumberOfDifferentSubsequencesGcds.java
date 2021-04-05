package number.of.different.subsequences.gcds;

/**
 * @author hum
 */
public class NumberOfDifferentSubsequencesGcds {
    public int countDifferentSubsequenceGCDs(int[] nums) {
        int res = 0;
        int max = 0;
//        Set<Integer> set = new HashSet<>();
        boolean[] vis = new boolean[(int) (2e5 + 5)];
        for (int num : nums) {
            max = Math.max(max, num);
//            set.add(num);
            vis[num] = true;
        }

        for (int i = 1; i <= max; i++) {
            int tmp = 0;
            for (int j = i; j <= max; j += i) {
//                if (set.contains(j)) {
                if (vis[j]) {
                    if (tmp == 0) {
                        tmp = j;
                    }
                    tmp = gcd(tmp, j);
                    if (tmp == i) {
                        res++;
                        break;
                    }
                }
            }
        }
        return res;
    }

    int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }
}
