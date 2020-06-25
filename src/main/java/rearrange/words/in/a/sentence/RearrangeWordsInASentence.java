package rearrange.words.in.a.sentence;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class RearrangeWordsInASentence {
    public String arrangeWords(String text) {
        String[] split = text.split(" ");
        split[0] = split[0].toLowerCase();
        int len = split.length;
        List<Word> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            list.add(new Word(split[i], split[i].length(), i));
        }
        list.sort((a, b) -> a.len == b.len ? a.index - b.index : a.len - b.len);
        StringBuilder sb = new StringBuilder();
        for (Word word : list) {
            sb.append(word.w);
            sb.append(" ");
        }
        sb.setCharAt(0, (char) (sb.charAt(0) - 'a' + 'A'));
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    class Word {
        String w;
        int len;
        int index;

        public Word(String w, int len, int index) {
            this.w = w;
            this.len = len;
            this.index = index;
        }
    }
}
