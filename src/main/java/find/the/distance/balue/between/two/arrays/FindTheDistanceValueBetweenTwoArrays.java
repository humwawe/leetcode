package find.the.distance.balue.between.two.arrays;

/**
 * @author hum
 */
public class FindTheDistanceValueBetweenTwoArrays {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int result = arr1.length;
        for (int i : arr1) {
            for (int j : arr2) {
                if (Math.abs(i - j) <= d) {
                    result--;
                    break;
                }
            }
        }
        return result;
    }

}
