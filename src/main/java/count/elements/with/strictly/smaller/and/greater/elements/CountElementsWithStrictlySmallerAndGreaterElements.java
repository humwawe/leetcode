package count.elements.with.strictly.smaller.and.greater.elements;

/**
 * @author hum
 */
public class CountElementsWithStrictlySmallerAndGreaterElements {
    public int countElements(int[] nums) {
        if (nums.length < 3) return 0;
        int res = 0, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        for (int num : nums) {
            if (num < max && num > min) {
                res++;
            }
        }
        return res;
    }

}
