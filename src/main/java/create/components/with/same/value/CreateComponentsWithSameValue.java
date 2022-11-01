package create.components.with.same.value;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hum
 */
public class CreateComponentsWithSameValue {
  private List<Integer>[] g;
  private int[] nums;
  private int target;

  public int componentValue(int[] nums, int[][] edges) {
    g = new ArrayList[nums.length];
    Arrays.setAll(g, e -> new ArrayList<>());
    for (int[] e : edges) {
      int x = e[0], y = e[1];
      g[x].add(y);
      g[y].add(x);
    }
    this.nums = nums;

    int total = Arrays.stream(nums).sum();
    int max = Arrays.stream(nums).max().orElseThrow();
    for (int i = total / max; ; --i) {
      if (total % i == 0) {
        target = total / i;
        if (dfs(0, -1) == 0) {
          return i - 1;
        }
      }
    }
  }

  private int dfs(int x, int fa) {
    int sum = nums[x]; // 价值
    for (int y : g[x]) {
      if (y != fa) {
        int res = dfs(y, x);
        if (res < 0) {
          return -1;
        }
        sum += res;
      }
    }
    if (sum > target) {
      return -1;
    }
    return sum < target ? sum : 0;
  }

}
