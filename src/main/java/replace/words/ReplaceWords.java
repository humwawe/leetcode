package replace.words;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author hum
 */
public class ReplaceWords {
    public String replaceWords(List<String> dict, String sentence) {
        Collections.sort(dict);
        List<String> data = new ArrayList<String>();
        for (String s : dict) {
            if (data.size() == 0 || !s.startsWith(data.get(data.size() - 1))) {
                data.add(s);
            }
        }
        String[] col = sentence.split(" ");
        for (int i = 0; i < col.length; i++) {
            String s = col[i];
            int index = Collections.binarySearch(data, s);
            if (index < 0) {
                index = -(index + 1);
                if (index > 0 && s.startsWith(data.get(index - 1))) {
                    col[i] = data.get(index - 1);
                }
            }
        }
        return String.join(" ", col);
    }
}
