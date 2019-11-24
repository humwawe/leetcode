package optimal.division;


/**
 * @author hum
 */
public class OptimalDivision {
    class retType {
        float maxVal, minVal;
        String minStr, maxStr;
    }

    public String optimalDivision(int[] nums) {
        retType[][] memo = new retType[nums.length][nums.length];
        retType t = optimal(nums, 0, nums.length - 1, "", memo);
        return t.maxStr;
    }

    private retType optimal(int[] nums, int start, int end, String res, retType[][] memo) {
        if (memo[start][end] != null) {
            return memo[start][end];
        }
        retType t = new retType();
        if (start == end) {
            t.maxVal = nums[start];
            t.minVal = nums[start];
            t.minStr = "" + nums[start];
            t.maxStr = "" + nums[start];
            memo[start][end] = t;
            return t;
        }
        t.minVal = Float.MAX_VALUE;
        t.maxVal = Float.MIN_VALUE;
        t.minStr = t.maxStr = "";
        for (int i = start; i < end; i++) {
            retType left = optimal(nums, start, i, "", memo);
            retType right = optimal(nums, i + 1, end, "", memo);
            if (t.minVal > left.minVal / right.maxVal) {
                t.minVal = left.minVal / right.maxVal;
                t.minStr = left.minStr + "/" + (i + 1 != end ? "(" : "") + right.maxStr + (i + 1 != end ? ")" : "");
            }
            if (t.maxVal < left.maxVal / right.minVal) {
                t.maxVal = left.maxVal / right.minVal;
                t.maxStr = left.maxStr + "/" + (i + 1 != end ? "(" : "") + right.minStr + (i + 1 != end ? ")" : "");
            }
        }
        memo[start][end] = t;
        return t;
    }

}
