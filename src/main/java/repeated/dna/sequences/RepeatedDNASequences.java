package repeated.dna.sequences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author hum
 */
public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String subSequence = s.substring(i, 10 + i);
            System.out.println(subSequence);
            if (set.contains(subSequence) && !result.contains(subSequence)) {
                result.add(subSequence);
            } else {
                set.add(subSequence);
            }
        }
        return result;
    }
}
