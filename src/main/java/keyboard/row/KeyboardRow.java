package keyboard.row;

import java.util.ArrayList;
import java.util.List;

public class KeyboardRow {
    public String[] findWords(String[] words) {
        List<String> result = new ArrayList<>();
        String lines[] = new String[]{"qwertyuiop", "asdfghjkl", "zxcvbnm"};

        for (String word : words) {
            String wordLower = word.toLowerCase();
            String tmp = lines[0];
            for (String line : lines) {
                if (line.indexOf(wordLower.charAt(0)) != -1) {
                    tmp = line;
                    break;
                }
            }
            boolean flag = true;
            for (int i = 1; i < wordLower.length(); i++) {
                if (tmp.indexOf(wordLower.charAt(i)) == -1) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result.add(word);
            }
        }
        return result.toArray(new String[0]);
    }
}
