package maximum.number.of.words.you.can.type;

/**
 * @author hum
 */
public class MaximumNumberOfWordsYouCanType {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] ss = text.split(" ");
        boolean[] vis = new boolean[26];
        for (char c : brokenLetters.toCharArray()) {
            vis[c - 'a'] = true;
        }
        int res = 0;
        f:
        for (String s : ss) {
            for (int i = 0; i < s.length(); i++) {
                if (vis[s.charAt(i) - 'a']) {
                    continue f;
                }
            }
            res++;
        }
        return res;
    }
}
