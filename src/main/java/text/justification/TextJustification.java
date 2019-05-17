package text.justification;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> results = new ArrayList<>();
        for (int i = 0; i < words.length; ) {
            int j = i;
            boolean lastLine = false;
            int len = words[j].length() + 1;
            while (j < words.length - 1 && len < maxWidth + 1) {
                len += words[++j].length() + 1;
            }
            if (len > maxWidth + 1) {
                len -= words[j--].length() + 1 + j - i + 1;
            } else {
                len -= j - i + 1;
                lastLine = true;
            }
            int space = maxWidth - len;
            StringBuilder result = new StringBuilder();
            if (j - i == 0) {
                result.append(words[i++]);
                while (space-- > 0) {
                    result.append(" ");
                }
            } else if (!lastLine) {
                int quotient = space / (j - i);
                int residue = space % (j - i);
                while (j - i > 0) {
                    result.append(words[i++]);
                    for (int k = 0; k < quotient; k++) {
                        result.append(" ");
                    }
                    if (residue-- > 0) {
                        result.append(" ");
                    }
                }
                result.append(words[i++]);
            } else {
                while (j - i >= 0) {
                    result.append(words[i++]);
                    if (space > 0) {
                        result.append(" ");
                        space--;
                    }
                }
                while (space-- > 0) {
                    result.append(" ");
                }

            }
            results.add(result.toString());
        }
        return results;
    }

}

