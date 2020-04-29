package partition.array.into.three.parts.with.equal.sum;

/**
 * @author hum
 */
public class PartitionArrayIntoThreePartsWithEqualSum {
    public boolean canThreePartsEqualSum(int[] a) {
        int sum = 0;
        for (int num : a) {
            sum += num;
        }

        if (sum % 3 != 0) {
            return false;
        }
        sum /= 3;
        int curSum = 0, cnt = 0;
        for (int i = 0; i < a.length; i++) {
            curSum += a[i];
            if (curSum == sum) {
                cnt++;
                curSum = 0;
            }
        }
        return cnt == 3 || (cnt > 3 && sum == 0);
    }
}
