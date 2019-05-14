package jump.game;

/**
 * @author hum
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        if (nums.length == 0) {
            return true;
        }
        int len = nums[0];
        for (int i = 0; i <= len; i++) {
            if (len >= nums.length - 1) {
                return true;
            }
            len = Math.max(nums[i] + i, len);
        }
        return false;
    }
}
