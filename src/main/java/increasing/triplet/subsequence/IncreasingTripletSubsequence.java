package increasing.triplet.subsequence;

/**
 * @author hum
 */
public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        int one = Integer.MAX_VALUE;
        int two = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= one) {
                one = num;
            } else if (num <= two) {
                two = num;
            } else {
                return true;
            }
        }
        return false;
    }
}
