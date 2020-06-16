package decompress.run.length.encoded.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class DecompressRunLengthEncodedList {
    public int[] decompressRLElist(int[] nums) {
        int len = nums.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i += 2) {
            int c = nums[i];
            int v = nums[i + 1];
            for (int j = 0; j < c; j++) {
                list.add(v);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
