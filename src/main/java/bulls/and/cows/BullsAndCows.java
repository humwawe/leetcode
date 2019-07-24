package bulls.and.cows;

import java.util.*;

/**
 * @author hum
 */
public class BullsAndCows {
    public String getHint(String secret, String guess) {
        int bull = 0;
        int cow = 0;
        Map<Character, Integer> map1 = new HashMap<>();
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < secret.length(); i++) {
            char c1 = secret.charAt(i);
            char c2 = guess.charAt(i);
            if (c1 == c2) {
                bull++;
            } else {
                if (map1.containsKey(c1)) {
                    map1.put(c1, map1.get(c1) + 1);
                } else {
                    map1.put(c1, 1);
                }
                list.add(c2);
            }
        }
        for (Character character : list) {
            if (map1.containsKey(character)) {
                if (map1.get(character) >= 1) {
                    cow++;
                    map1.put(character, map1.get(character) - 1);
                }
            }
        }
        return bull + "A" + cow + "B";
    }
}
