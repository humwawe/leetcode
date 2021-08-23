package find.unique.binary.string;

/**
 * @author hum
 */
public class FindUniqueBinaryString {
    public String findDifferentBinaryString(String[] nums) {
        int len = nums.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            String s = nums[i];
            int num = s.charAt(i) - '0';
            sb.append(num ^ 1);
        }
        return sb.toString();
    }
}
