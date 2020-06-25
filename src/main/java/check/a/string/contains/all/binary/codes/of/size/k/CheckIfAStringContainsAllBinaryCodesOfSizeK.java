package check.a.string.contains.all.binary.codes.of.size.k;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hum
 */
public class CheckIfAStringContainsAllBinaryCodesOfSizeK {
    public boolean hasAllCodes(String s, int k) {
        int len = s.length();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < len - k + 1; i++) {
            set.add(s.substring(i, i + k));
        }
        return set.size() == (int) Math.pow(2, k);
    }
}
