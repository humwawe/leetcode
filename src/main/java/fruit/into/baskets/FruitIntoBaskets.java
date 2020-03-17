package fruit.into.baskets;

/**
 * @author hum
 */
public class FruitIntoBaskets {
    public int totalFruit(int[] tree) {
        int len = tree.length;
        int[] hash = new int[len + 1];
        int count = 0;
        int j = 0;
        int result = 0;
        for (int i = 0; i < len; i++) {
            hash[tree[i]]++;
            if (hash[tree[i]] == 1) {
                count++;
            }
            while (count > 2 && j < i) {
                hash[tree[j]]--;
                if (hash[tree[j]] == 0) {
                    count--;
                }
                j++;
            }
            result = Math.max(result, i - j + 1);
        }
        return result;
    }
}
