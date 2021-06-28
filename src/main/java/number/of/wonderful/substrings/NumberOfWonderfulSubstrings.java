package number.of.wonderful.substrings;

/**
 * @author hum
 */
public class NumberOfWonderfulSubstrings {
    public long wonderfulSubstrings(String word) {
        int len = word.length();
        int[] map = new int[1 << 10];
        map[0] = 1;
        int sum = 0;
        long res = 0;
        for (int i = 0; i < len; i++) {
            int cur = word.charAt(i) - 'a';
            sum ^= (1 << cur);
            res += map[sum];
            for (int j = 0; j < 10; j++) {
                int tmp = sum ^ (1 << j);
                res += map[tmp];
            }
            map[sum]++;
        }
        return res;
    }
}
