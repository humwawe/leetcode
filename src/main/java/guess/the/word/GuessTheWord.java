package guess.the.word;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class GuessTheWord {
    public void findSecretWord(String[] wordlist, Master master) {
        for (int i = 0, cnt = 0; i < 10 && cnt < 6; ++i) {
            String guess = wordlist[0];
            cnt = master.guess(guess);
            List<String> list = new ArrayList<>();
            for (String word : wordlist) {
                if (match(guess, word) == cnt) {
                    list.add(word);
                }
            }
            wordlist = list.toArray(new String[0]);
        }
    }

    private int match(String a, String b) {
        int res = 0, len = a.length();
        for (int i = 0; i < len; ++i) {
            if (a.charAt(i) == b.charAt(i)) {
                ++res;
            }
        }
        return res;
    }
}

class Master {
    public int guess(String word) {
        return 0;
    }
}
