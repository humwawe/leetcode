package number.of.good.paths;

import java.util.*;

/**
 * @author hum
 */
public class NumberOfGoodPaths {
  public int numberOfGoodPaths(int[] vals, int[][] edges) {
    n = vals.length;
    p = new int[n];
    List<Integer>[] lists = new List[n];
    Integer[] idx = new Integer[n];
    for (int i = 0; i < n; i++) {
      p[i] = i;
      idx[i] = i;
      lists[i] = new ArrayList<>();
    }
    for (int[] edge : edges) {
      lists[edge[0]].add(edge[1]);
      lists[edge[1]].add(edge[0]);
    }
    Arrays.sort(idx, Comparator.comparingInt(x -> vals[x]));
    int res = n;
    for (int i = 0; i < n; i++) {
      int val = vals[idx[i]];
      int j = i;
      Set<Integer> set = new HashSet<>();
      set.add(idx[i]);
      while (j + 1 < n && vals[idx[j + 1]] == val) {
        j++;
        set.add(idx[j]);
      }
      for (Integer u : set) {
        for (Integer v : lists[u]) {
          if (vals[v] <= val) {
            union(u, v);
          }
        }
      }
      Map<Integer, Integer> map = new HashMap<>();
      for (Integer u : set) {
        map.put(find(u), map.getOrDefault(find(u), 0) + 1);
      }
      for (Integer value : map.values()) {
        res += value * (value - 1) / 2;
      }

      i = j;
    }
    return res;

  }

  int n = 100;
  int[] p;


  int find(int x) {
    if (p[x] != x) {
      p[x] = find(p[x]);
    }
    return p[x];
  }

  void union(int a, int b) {
    if (find(a) == find(b)) {
      return;
    }
    p[find(a)] = find(b);
  }
}
