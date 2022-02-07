package smallest.value.of.the.rearranged.number;

/**
 * @author hum
 */
public class SmallestValueOfTheRearrangedNumber {
    public long smallestNumber(long num) {
        if (num == 0) {
            return 0;
        }

        int[] cnt = new int[10];
        if (num > 0) {
            String s = String.valueOf(num);
            for (char c : s.toCharArray()) {
                cnt[c - '0']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < 10; i++) {
                for (int j = 0; j < cnt[i]; j++) {
                    sb.append(i);
                }
            }
            for (int i = 0; i < cnt[0]; i++) {
                sb.insert(1, 0);
            }
            return Long.parseLong(sb.toString());
        }
        String s = String.valueOf(-num);
        for (char c : s.toCharArray()) {
            cnt[c - '0']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            for (int j = 0; j < cnt[i]; j++) {
                sb.append(i);
            }
        }
        return -Long.parseLong(sb.toString());
    }
}
