package container_with_most_water;

/**
 * @author hum
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
     /* 超时
        int result = 0, temp = 0;
        int length = height.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                temp = Math.min(height[i], height[j]) * (j - i);
                if (temp > result) {
                    result = temp;
                }
            }
        }
        return result;*/

        int result = 0;
        int temp = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            temp = Math.min(height[left], height[right]) * (right - left);
            if (temp > result) {
                result = temp;
            }
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}