package buddy.strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author hum
 */
public class BuddyStrings {
    public boolean buddyStrings(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        List<Integer> res = new ArrayList<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                res.add(i);
            }
            set.add(a.charAt(i));
        }
        if (res.isEmpty()) {
            return a.length() > set.size();
        }
        return res.size() == 2 && a.charAt(res.get(0)) == b.charAt(res.get(1)) && a.charAt(res.get(1)) == b.charAt(res.get(0));
    }
}
