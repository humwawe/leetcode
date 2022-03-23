package longest.substring.of.one.repeating.character;

import java.util.Comparator;
import java.util.Objects;
import java.util.TreeSet;

/**
 * @author hum
 */
public class LongestSubstringOfOneRepeatingCharacter {
  TreeSet<Node> set1, set2;

  public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
    set1 = new TreeSet<>(Comparator.comparingInt(x -> x.l));
    set2 = new TreeSet<>((x, y) -> {
      int d = x.len - y.len;
      if (d == 0) {
        return x.l - y.l;
      }
      return d;
    });
    char[] chars = s.toCharArray();
    int len = chars.length;
    for (int i = 0; i < len; ) {
      int j = i;
      while (j + 1 < len && chars[j + 1] == chars[i]) {
        j++;
      }
      set1.add(new Node(i, j));
      set2.add(new Node(i, j));
      i = j + 1;
    }
    int[] res = new int[queryCharacters.length()];
    for (int i = 0; i < queryCharacters.length(); i++) {
      int idx = queryIndices[i];
      char c = queryCharacters.charAt(i);
      if (c == chars[idx]) {
        res[i] = set2.last().len;
        continue;
      }
      chars[idx] = c;
      del(idx);
      del(idx + 1);
      if (idx > 0 && chars[idx - 1] == c) {
        merge(idx);
      }
      if (idx + 1 < len && chars[idx + 1] == c) {
        merge(idx + 1);
      }
      res[i] = set2.last().len;
    }
    return res;
  }

  private void merge(int idx) {
    Node tmp = new Node(idx, idx);
    Node floor = set1.floor(tmp);
    Node lower = set1.lower(tmp);
    set1.remove(floor);
    set2.remove(floor);
    set1.remove(lower);
    set2.remove(lower);
    set1.add(new Node(lower.l, floor.r));
    set2.add(new Node(lower.l, floor.r));
  }

  private void del(int idx) {
    Node floor = set1.floor(new Node(idx, idx));
    if (floor.l == idx || idx > floor.r) {
      return;
    }
    set1.remove(floor);
    set2.remove(floor);
    set1.add(new Node(floor.l, idx - 1));
    set2.add(new Node(floor.l, idx - 1));
    set1.add(new Node(idx, floor.r));
    set2.add(new Node(idx, floor.r));
  }

  class Node {
    int l;
    int r;
    int len;

    public Node(int l, int r) {
      this.l = l;
      this.r = r;
      this.len = r - l + 1;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof Node)) {
        return false;
      }
      Node node = (Node) o;
      return l == node.l && r == node.r && len == node.len;
    }

    @Override
    public int hashCode() {
      return Objects.hash(l, r, len);
    }
  }

}

