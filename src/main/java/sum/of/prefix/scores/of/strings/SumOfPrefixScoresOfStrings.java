package sum.of.prefix.scores.of.strings;

/**
 * @author hum
 */
public class SumOfPrefixScoresOfStrings {
  public int[] sumPrefixScores(String[] words) {
    for (String word : words) {
      insert(word);
    }
    int[] res = new int[words.length];
    for (int i = 0; i < words.length; i++) {
      res[i] = query(words[i]);
    }
    return res;

  }

  int n = 1000000;
  int[][] son = new int[26][n];
  int[] cnt = new int[n];
  int idx = 0;

  void insert(String str) {
    int p = 0;
    for (int i = 0; i < str.length(); i++) {
      int u = str.charAt(i) - 'a';
      if (son[u][p] == 0) {
        son[u][p] = ++idx;
      }
      p = son[u][p];
      cnt[p]++;
    }
  }

  // 查询字符串出现的次数
  int query(String str) {
    int p = 0;
    int sum = 0;
    for (int i = 0; i < str.length(); i++) {
      int u = str.charAt(i) - 'a';
      if (son[u][p] == 0) {
        return 0;
      }
      p = son[u][p];
      sum += cnt[p];
    }
    return sum;
  }
}
