package occurrences.after.bigram;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class OccurrencesAfterBigram {
    public String[] findOcurrences(String text, String first, String second) {
        String[] split = text.split(" ");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < split.length - 2; i++) {
            if (first.equals(split[i]) && second.equals(split[i + 1])) {
                list.add(split[i + 2]);
            }
        }
        return list.toArray(new String[0]);
    }
}
