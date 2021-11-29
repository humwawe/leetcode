package minimum.number.of.buckets.required.to.collect.rainwater.from.houses;

/**
 * @author hum
 */
public class MinimumNumberOfBucketsRequiredToCollectRainwaterFromHouses {
    public int minimumBuckets(String street) {
        int len = street.length();
        street = '&' + street + '&';
        boolean[] vis = new boolean[len+2];
        for (int i = 1; i <= len; i++) {
            char c = street.charAt(i);
            if (c == 'H') {
                if (vis[i - 1]) {
                    continue;
                }
                if (street.charAt(i + 1) != '.' && street.charAt(i - 1) != '.') {
                    return -1;
                }
                if (street.charAt(i + 1) == '.') {
                    vis[i + 1] = true;
                } else {
                    vis[i - 1] = true;
                }
            }
        }
        int res = 0;
        for (int i = 1; i <= len; i++) {
            if (vis[i]) {
                res++;
            }
        }
        return res;
    }
}
