package booking.concert.tickets.in.groups;

/**
 * @author hum
 */
public class BookingConcertTicketsInGroups {
  int n, m;
  SegmentTree segmentTree;
  int full;
  int[] a;

  public BookingConcertTicketsInGroups(int n, int m) {
    this.n = n;
    this.m = m;
    a = new int[n + 2];

    segmentTree = new SegmentTree(n);
    segmentTree.build(1, 1, n);
    full = 1;
  }

  public int[] gather(int k, int maxRow) {

    int l = full;
    int r = maxRow + 2;
    while (l < r) {
      int mid = l + r >> 1;
      int max = segmentTree.query(1, full, mid);
      if (max >= k) {
        r = mid;
      } else {
        l = mid + 1;
      }
    }
    if (l >= maxRow + 2) {
      return new int[]{};
    }
    int t = a[l];
    a[l] += k;
    segmentTree.modify(1, l, -k);
    return new int[]{l - 1, t};
  }

  public boolean scatter(int k, int maxRow) {
    if (full > maxRow + 1 || segmentTree.querySum(1, full, maxRow + 1) < k) {
      return false;
    }
    int i;
    for (i = full; i <= maxRow + 1; i++) {
      if (k >= m - a[i]) {
        k -= m - a[i];
        a[i] = m;
      } else {
        a[i] += k;
        segmentTree.modify(1, i, -k);
        break;
      }
    }
    full = i;
    if (a[i] == m) {
      full++;
    }
    return true;
  }

  class SegmentTree {
    int N;
    Node[] tr;

    public SegmentTree(int n) {
      this.N = n + 5;
      tr = new Node[N * 4];
    }

    public SegmentTree(int[] w) {
      this.N = w.length + 5;
      tr = new Node[N * 4];
    }

    void pushUp(int u) {
      tr[u].max = Math.max(tr[u << 1].max, tr[u << 1 | 1].max);
      tr[u].sum = tr[u << 1].sum + tr[u << 1 | 1].sum;
    }

    // 从u开始，构建[l,r]的树，w[i]存每个节点的值(1开始)
    void build(int u, int l, int r) {
      if (l == r) {
        tr[u] = new Node(l, r, m, m);
        return;
      }
      tr[u] = new Node(l, r);
      int mid = l + r >> 1;
      build(u << 1, l, mid);
      build(u << 1 | 1, mid + 1, r);
      pushUp(u);
    }

    // 从u开始查找
    int query(int u, int l, int r) {
      // 已经完全在[l,r]中了
      if (tr[u].l >= l && tr[u].r <= r) {
        return tr[u].max;
      }
      int mid = tr[u].l + tr[u].r >> 1;
      int v = Integer.MIN_VALUE;
      if (l <= mid) {
        v = query(u << 1, l, r);
      }
      if (r > mid) {
        v = Math.max(v, query(u << 1 | 1, l, r));
      }
      return v;
    }

    long querySum(int u, int l, int r) {
      // 已经完全在[l,r]中了
      if (tr[u].l >= l && tr[u].r <= r) {
        return tr[u].sum;
      }
      int mid = tr[u].l + tr[u].r >> 1;
      long v = 0;
      if (l <= mid) {
        v += querySum(u << 1, l, r);
      }
      if (r > mid) {
        v += querySum(u << 1 | 1, l, r);
      }
      return v;
    }

    void modify(int u, int x, int v) {
      if (tr[u].l == x && tr[u].r == x) {
        tr[u].max += v;
        tr[u].sum += v;
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
      int max;
      long sum;

      public Node(int l, int r) {
        this.l = l;
        this.r = r;
      }

      public Node(int l, int r, int max, long sum) {
        this.l = l;
        this.r = r;
        this.max = max;
        this.sum = sum;
      }
    }


  }
}
