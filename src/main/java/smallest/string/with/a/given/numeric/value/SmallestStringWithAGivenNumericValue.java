package smallest.string.with.a.given.numeric.value;

/**
 * @author hum
 */
public class SmallestStringWithAGivenNumericValue {
    public String getSmallestString(int n, int k) {
        int t = k - n;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (t > 25) {
                stringBuilder.append((char) ('a' + 25));
                t -= 25;
            } else {
                stringBuilder.append((char) ('a' + t));
                t = 0;
            }
        }
        return stringBuilder.reverse().toString();
    }
}
