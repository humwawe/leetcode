package count.triplets.that.can.form.two.arrays.of.equal.xor;

/**
 * @author hum
 */
public class CountTripletsThatCanFormTwoArraysOfEqualXOR {
    public int countTriplets(int[] arr) {
        int len = arr.length;
        int result = 0;
        for (int i = 0; i < len; i++) {
            int sum = arr[i];
            for (int j = i + 1; j < len; j++) {
                sum ^= arr[j];
                if (sum == 0) {
                    result += j - i;
                }
            }
        }
        return result;
    }
}
