package minimum.adjacent.swaps.to.reach.the.kth.smallest.number;

/**
 * @author hum
 */
public class MinimumAdjacentSwapsToReachTheKthSmallestNumber {
    public int getMinSwaps(String num, int k) {
        char[] b = num.toCharArray();
        char[] c = b.clone();
        while (k-- > 0) {
            nextPermutation(b);
        }
        int ans = 0;
        for (int i = 0; i < num.length(); i++) {
            if (c[i] != b[i]) {
                int j = i + 1;
                while (b[j] != c[i]) {
                    j++;
                }
                while (j != i) {
                    swap(b, j - 1, j);
                    ans++;
                    j--;
                }
            }
        }
        return ans;
    }

    public void nextPermutation(char[] b) {
        for (int i = b.length - 1; i > 0; i--) {
            if (b[i] > b[i - 1]) {
                int j = b.length - 1;
                while (b[j] <= b[i - 1]) {
                    j--;
                }
                swap(b, i - 1, j);
                j = b.length - 1;
                while (i < j) {
                    swap(b, i++, j--);
                }
                break;
            }
        }
    }

    public void swap(char[] b, int i, int j) {
        char t = b[i];
        b[i] = b[j];
        b[j] = t;
    }

}
