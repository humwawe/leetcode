package remove.boxes;


/**
 * @author hum
 */
public class RemoveBoxes {
    private int[][][] memo;

    public int removeBoxes(int[] boxes) {
        int len = boxes.length;
        memo = new int[len][len][len];
        return helper(boxes, 0, len - 1, 0);
    }

    public int helper(int[] boxes, int l, int r, int k) {
        if (l > r) {
            return 0;
        }
        if (memo[l][r][k] != 0) {
            return memo[l][r][k];
        }
        while (r > l && boxes[r] == boxes[r - 1]) {
            r--;
            k++;
        }
        memo[l][r][k] = helper(boxes, l, r - 1, 0) + (k + 1) * (k + 1);
        for (int i = l; i < r; i++) {
            if (boxes[i] == boxes[r]) {
                memo[l][r][k] = Math.max(memo[l][r][k], helper(boxes, l, i, k + 1) + helper(boxes, i + 1, r - 1, 0));
            }
        }
        return memo[l][r][k];
    }
}
