package longest.substring.of.one.repeating.character;

/**
 * @author hum
 */
public class LongestSubstringOfOneRepeatingCharacter {
  public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
    chars = (" " + s).toCharArray();
    build(1, 1, chars.length - 1);
    int len = queryIndices.length;
    int[] res = new int[len];
    for (int i = 0; i < len; i++) {
      modify(1, queryIndices[i] + 1, queryCharacters.charAt(i));
      res[i] = query(1, 1, chars.length - 1);
    }
    return res;
  }

  int N = (int) (1e5 + 5);
  Node[] tr = new Node[N * 4];
  char[] chars;

  void pushUp(int u) {
    Node l = tr[u << 1];
    Node r = tr[u << 1 | 1];
    Node cur = tr[u];
    cur.max = Math.max(l.max, r.max);
    cur.lmax = l.lmax;
    cur.rmax = r.rmax;
    cur.lc = l.lc;
    cur.rc = r.rc;

    if (l.rc == r.lc) {
      cur.max = Math.max(cur.max, l.rmax + r.lmax);
      if (l.lmax == l.r - l.l + 1) {
        cur.lmax += r.lmax;
      }
      if (r.rmax == r.r - r.l + 1) {
        cur.rmax += l.rmax;
      }
    }
  }

  void build(int u, int l, int r) {
    if (l == r) {
      tr[u] = new Node(l, r, 1, chars[l], 1, chars[r], 1);
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

  void modify(int u, int x, char c) {
    if (tr[u].l == x && tr[u].r == x) {
      tr[u].lc = c;
      tr[u].rc = c;
      return;
    }
    int mid = tr[u].l + tr[u].r >> 1;
    if (x <= mid) {
      modify(u << 1, x, c);
    } else {
      modify(u << 1 | 1, x, c);
    }
    pushUp(u);
  }

  class Node {
    int l;
    int r;
    int lmax;
    char lc;
    int rmax;
    char rc;
    int max;

    public Node(int l, int r) {
      this.l = l;
      this.r = r;
    }

    public Node(int l, int r, int lmax, char lc, int rmax, char rc, int max) {
      this.l = l;
      this.r = r;
      this.lmax = lmax;
      this.lc = lc;
      this.rmax = rmax;
      this.rc = rc;
      this.max = max;
    }
  }
}
