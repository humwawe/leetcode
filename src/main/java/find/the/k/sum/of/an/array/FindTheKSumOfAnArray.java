package find.the.k.sum.of.an.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author hum
 */
public class FindTheKSumOfAnArray {
  public long kSum(int[] nums, int k) {
    int n = nums.length;
    long maxSum = 0;                    // nums 的所有子序列的最大和
    for (int i = 0; i < n; i++) {
      if (nums[i] > 0) {
        maxSum += nums[i];
      }
      nums[i] = Math.abs(nums[i]);          // 所有元素取绝对值
    }
    Arrays.sort(nums);                          // 对不含负数的数组做排序，时间复杂度：O(nlogn)

    PriorityQueue<Sequence> heap = new PriorityQueue<>(Comparator.comparingLong(a -> a.sum));
    heap.offer(new Sequence(nums[0], 0));         // 我们枚举子序列的起点：和最小的【非空】子序列
    long target = 0L;         // 目标要求的【第 k 小的子序列和】，初始为 0，即第 1 小的子序列和 —— 空子序列
    while (--k > 0) {       // 只需要再抛出 k - 1 个子序列
      Sequence seq = heap.poll();
      long sum = seq.sum;         // 当前「子序列节点」的 sum
      int idx = seq.tailIdx;      // 当前「子序列节点」的末尾元素 idx
      target = sum;

      if (idx < n - 1) {
        heap.offer(new Sequence(sum + nums[idx + 1], idx + 1));     // 待加入的新子序列：当前抛出的子序列后面直接加上后一个元素
        heap.offer(new Sequence(sum - nums[idx] + nums[idx + 1], idx + 1));    // 待加入的新子序列：使用后一个元素替换掉当前抛出的子序列的末尾元素
        // 可以发现，我们新放入堆中的子序列和一定大于我们抛出的子序列和
      }
    }
    return maxSum - target;
  }

  class Sequence {
    long sum;       // 该子序列的和
    int tailIdx;    // 该子序列最后一个元素的下标

    public Sequence(long sum, int tailIdx) {
      this.sum = sum;
      this.tailIdx = tailIdx;
    }
  }
}
