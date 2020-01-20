package jewels.and.stones;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hum
 */
public class JewelsAndStones {
    public int numJewelsInStones(String j, String s) {
        Set<Character> set = new HashSet<>();
        for (char c : j.toCharArray()) {
            set.add(c);
        }
        int result = 0;
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                result++;
            }
        }
        return result;
    }
}
