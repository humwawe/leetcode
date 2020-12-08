package find.k.pairs.with.smallest.sums;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author hum
 */
public class FindKPairsWithSmallestSums {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> results = new ArrayList<>();
        Queue<Helper> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1.sum == o2.sum) {
                if (o1.index1 == o2.index1) {
                    return o1.index2 - o2.index2;
                } else {
                    return o1.index1 - o2.index1;
                }
            }
            return o1.sum - o2.sum;
        });

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                List<Integer> temp = new ArrayList<>();
                temp.add(nums1[i]);
                temp.add(nums2[j]);
                int sum = nums1[i] + nums2[j];
                Helper helper = new Helper(sum, temp, i, j);
                queue.add(helper);
            }
        }

        while (!queue.isEmpty() && results.size() < k) {
            results.add(queue.poll().result);
        }
        return results;
    }

}

class Helper {
    int sum;
    List<Integer> result;
    int index1;
    int index2;

    Helper(int sum, List<Integer> result, int index1, int index2) {
        this.sum = sum;
        this.result = result;
        this.index1 = index1;
        this.index2 = index2;
    }
}
