package group.anagrams;

import permutations.Permutations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hum
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, List<String>> map = new HashMap<>();
        int[] primeNumber = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        for (int i = 0; i < strs.length; i++) {
            int tmp = 1;
            for (char c : strs[i].toCharArray()) {
                tmp *= primeNumber[c - 'a'];
            }
            if (map.containsKey(tmp)) {
                map.get(tmp).add(strs[i]);
            } else {
                List<String> result = new ArrayList<>();
                result.add(strs[i]);
                map.put(tmp, result);
            }
        }
        return new ArrayList<>(map.values());
    }
}
