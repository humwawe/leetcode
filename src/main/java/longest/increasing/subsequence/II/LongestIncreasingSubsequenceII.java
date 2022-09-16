package longest.increasing.subsequence.II;

/**
 * @author PF-2CRL0N
 */
public class LongestIncreasingSubsequenceII {
  public int lengthOfLIS(int[] nums, int k) {
    int len = nums.length;
    int[] dp = new int[len + 1];

    build(1, 0, (int) (1e5));
    int res = 0;
    for (int i = 1; i <= len; i++) {
      int l = nums[i - 1] - k;
      int r = nums[i - 1] - 1;
      int maxPre = query(1, l, r);
      dp[i] = maxPre + 1;
      modify(1, nums[i - 1], dp[i]);
      res = Math.max(res, dp[i]);
    }
    return res;

  }


  int N = (int) (4e5 + 5);
  Node[] tr = new Node[N];

  void pushUp(int u) {
    tr[u].v = Math.max(tr[u << 1].v, tr[u << 1 | 1].v);
  }

  void build(int u, int l, int r) {
    if (l == r) {
      tr[u] = new Node(l, r, 0);
      return;
    }
    tr[u] = new Node(l, r);
    int mid = l + r >> 1;
    build(u << 1, l, mid);
    build(u << 1 | 1, mid + 1, r);
    pushUp(u);
  }

  int query(int u, int l, int r) {
    if (tr[u].l >= l && tr[u].r <= r) {
      return tr[u].v;
    }
    int mid = tr[u].l + tr[u].r >> 1;
    if (r <= mid) {
      return query(u << 1, l, r);
    } else if (l > mid) {
      return query(u << 1 | 1, l, r);
    } else {
      return Math.max(query(u << 1, l, r), query(u << 1 | 1, l, r));
    }
  }

  void modify(int u, int x, int v) {
    if (tr[u].l == x && tr[u].r == x) {
      tr[u].v = v;
      return;
    }
    int mid = tr[u].l + tr[u].r >> 1;
    if (x <= mid) {
      modify(u << 1, x, v);
    } else {
      modify(u << 1 | 1, x, v);
    }
    pushUp(u);
  }

  class Node {
    int l;
    int r;
    int v;

    public Node(int l, int r) {
      this.l = l;
      this.r = r;
    }

    public Node(int l, int r, int v) {
      this.l = l;
      this.r = r;
      this.v = v;
    }
  }
}
