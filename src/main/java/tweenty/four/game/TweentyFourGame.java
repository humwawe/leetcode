package tweenty.four.game;

/**
 * @author hum
 */
public class TweentyFourGame {
    public boolean judgePoint24(int[] nums) {
        double[] tran = new double[nums.length];
        for (int i = 0; i < tran.length; i++) {
            tran[i] = nums[i];
        }

        return helper(tran);
    }

    private boolean helper(double[] nums) {
        if (nums.length == 1) {
            return Math.abs(nums[0] - 24) / 24 < 1e-5;
        } else {
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    for (double newExp : combine(nums[i], nums[j])) {
                        double[] newList = new double[nums.length - 1];
                        for (int p = 0, k = 0; k < nums.length; k++) {
                            if (k != i && k != j) {
                                newList[p++] = nums[k];
                            }
                        }
                        newList[newList.length - 1] = newExp;
                        if (helper(newList)) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    private double[] combine(double a, double b) {
        return new double[]{a + b, a - b, b - a, a * b, a / b, b / a};
    }

}
