package stickers.to.spell.word;

import java.util.*;

/**
 * @author hum
 */
public class StickersToSpellWord {
    int result = Integer.MAX_VALUE;
    int len;

    public int minStickers(String[] stickers, String target) {
        len = target.length();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : target.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<Map<Character, Integer>> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (String sticker : stickers) {
            Map<Character, Integer> tmp = new HashMap<>();
            StringBuilder stringBuilder = new StringBuilder();
            for (Character character : map.keySet()) {
                for (char c : sticker.toCharArray()) {
                    if (c == character) {
                        tmp.put(c, tmp.getOrDefault(c, 0) + 1);
                    }
                }
                stringBuilder.append(character).append(tmp.getOrDefault(character, 0));
            }
            if (tmp.size() > 0 && !set.contains(stringBuilder.toString())) {
                set.add(stringBuilder.toString());
                list.add(tmp);
            }
        }
        //System.out.println(list);
        Set<Integer> t = removeList(list);
        for (int i = list.size() - 1; i >= 0; i--) {
            if (t.contains(i)) {
                list.remove(i);
            }
        }
        helper(list, map, 0);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private Set<Integer> removeList(List<Map<Character, Integer>> list) {
        Set<Integer> res = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            Map<Character, Integer> map1 = list.get(i);
            boolean flag = false;
            for (int j = 0; j < list.size(); j++) {
                if (i == j) {
                    continue;
                }
                Map<Character, Integer> map2 = list.get(j);
                boolean canRemove = true;
                for (Character character : map1.keySet()) {
                    if (map1.get(character) > map2.getOrDefault(character, 0)) {
                        canRemove = false;
                        break;
                    }
                }
                if (canRemove) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                res.add(i);
            }
        }
        return res;
    }

    private void helper(List<Map<Character, Integer>> list, Map<Character, Integer> map, int count) {
        if (result <= count) {
            return;
        }

        if (check(map)) {
            result = Math.min(result, count);
        }
        if (count >= len) {
            return;
        }
        for (Map<Character, Integer> tmp : list) {
            List<Character> con = check2(tmp, map);
            if (con.size() > 0) {
                for (Character character : con) {
                    map.put(character, map.get(character) - tmp.get(character));
                }
                helper(list, map, count + 1);
                for (Character character : con) {
                    map.put(character, map.get(character) + tmp.get(character));
                }
            }
        }
    }

    private List<Character> check2(Map<Character, Integer> tmp, Map<Character, Integer> map) {
        List<Character> res = new ArrayList<>();
        for (Character character : map.keySet()) {
            if (map.get(character) > 0 && tmp.containsKey(character)) {
                res.add(character);
            }
        }
        return res;
    }

    private boolean check(Map<Character, Integer> map) {
        for (Integer integer : map.values()) {
            if (integer > 0) {
                return false;
            }
        }
        return true;
    }
}
