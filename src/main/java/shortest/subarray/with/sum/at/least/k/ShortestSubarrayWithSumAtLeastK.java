package shortest.subarray.with.sum.at.least.k;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author hum
 */
public class ShortestSubarrayWithSumAtLeastK {
    class Solution {
        public int shortestSubarray(int[] a, int k) {
            int len = a.length;
            long[] prevSum = new long[len + 1];
            for (int i = 0; i < len; ++i) {
                prevSum[i + 1] = prevSum[i] + (long) a[i];
            }

            int result = len + 1;
            Deque<Integer> deque = new LinkedList<>();

            for (int y = 0; y < prevSum.length; ++y) {
                while (!deque.isEmpty() && prevSum[y] <= prevSum[deque.getLast()]) {
                    deque.removeLast();
                }
                while (!deque.isEmpty() && prevSum[y] >= prevSum[deque.getFirst()] + k) {
                    result = Math.min(result, y - deque.removeFirst());
                }
                deque.addLast(y);
            }
            return result < len + 1 ? result : -1;
        }
    }
}
