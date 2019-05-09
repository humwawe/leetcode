package trapping.rain.water;

/**
 * @author hum
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        if (height.length <= 2) {
            return 0;
        }
        int result = 0;
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        leftMax[0] = height[0];
        for (int i = 1; i < height.length - 1; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        rightMax[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i > 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            result += Math.max((Math.min(leftMax[i], rightMax[i]) - height[i]), 0);
        }

        return result;
    }
}
