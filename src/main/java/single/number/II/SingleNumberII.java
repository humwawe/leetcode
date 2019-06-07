package single.number.II;

/**
 * @author hum
 */
public class SingleNumberII {
    public int singleNumber(int[] nums) {
        int result = 0;
        int[] temp = new int[32];
        for (int num : nums) {
            int r = 1;
            int j = 31;
            while (j >= 0) {
                if ((num & r) != 0) {
                    temp[j]++;
                }
                j--;
                r = r << 1;
            }
        }
        int r = 1;
        int j = 31;

        while (j >= 0) {
            if (temp[j] % 3 != 0) {
                result = result ^ r;
            }
            r = r << 1;
            j--;
        }
        return result;
    }
}
