package sum.of.unique.elements;

/**
 * @author hum
 */
public class SumOfUniqueElements {
    public int sumOfUnique(int[] nums) {
        int[] cnt = new int[105];
        for (int num : nums) {
            cnt[num]++;
        }
        int res = 0;
        for (int num : nums) {
            if (cnt[num] == 1) {
                res += num;
            }
        }
        return res;
    }
}
