package decode.xored.permutation;

/**
 * @author hum
 */
public class DecodeXORedPermutation {
    public int[] decode(int[] encoded) {
        int len = encoded.length;
        int tmp = 0;
        for (int i = 1; i <= len + 1; i++) {
            tmp = tmp ^ i;
        }
        int dis = 0;
        for (int i = 1; i < len; i += 2) {
            dis = dis ^ encoded[i];
        }
        int first = tmp ^ dis;
        int[] res = new int[len + 1];
        res[0] = first;
        for (int i = 1; i < len + 1; i++) {
            res[i] = res[i - 1] ^ encoded[i - 1];
        }
        return res;
    }
}
