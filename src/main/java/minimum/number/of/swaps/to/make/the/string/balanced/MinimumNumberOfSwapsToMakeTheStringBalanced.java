package minimum.number.of.swaps.to.make.the.string.balanced;

/**
 * @author hum
 */
public class MinimumNumberOfSwapsToMakeTheStringBalanced {
    public int minSwaps(String s) {
        int cnt = 0;
        int res = 0;
        for (char c : s.toCharArray()) {
            if (c == '[') {
                cnt++;
            } else {
                cnt--;
                if (cnt < 0) {
                    res++;
                    cnt += 2;
                }
            }
        }
        return res;
    }
}
