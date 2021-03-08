package minimum.elements.to.add.to.form.a.given.sum;

/**
 * @author hum
 */
public class MinimumElementsToAddToFormAGivenSum {
    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        long tar = (long) goal - sum;
        return (int) ((Math.abs(tar) + limit - 1) / limit);
    }
}
