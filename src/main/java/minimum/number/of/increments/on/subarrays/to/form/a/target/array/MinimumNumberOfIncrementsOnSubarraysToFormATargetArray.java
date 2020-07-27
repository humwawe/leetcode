package minimum.number.of.increments.on.subarrays.to.form.a.target.array;

/**
 * @author hum
 */
public class MinimumNumberOfIncrementsOnSubarraysToFormATargetArray {
    public int minNumberOperations(int[] target) {
        int len = target.length;
        int result = 0;
        for (int i = 0; i < len - 1; i++) {
            if (target[i] > target[i + 1]) {
                result += target[i] - target[i + 1];
            }
        }
        result += target[len - 1];
        return result;
    }
}
