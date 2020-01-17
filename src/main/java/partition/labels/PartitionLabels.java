package partition.labels;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        int prev = -1;
        int end = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if (i >= end) {
                result.add(i - prev);
                prev = i;
            }
        }
        return result;
    }
}
