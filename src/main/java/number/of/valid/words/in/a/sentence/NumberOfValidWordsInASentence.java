package number.of.valid.words.in.a.sentence;

/**
 * @author hum
 */
public class NumberOfValidWordsInASentence {
    public int countValidWords(String sentence) {
        String[] s = sentence.split("\\s+");
        int res = 0;
        for (String s1 : s) {
            if (s1.length() == 0) {
                continue;
            }
            boolean f = true;
            for (char c : s1.toCharArray()) {
                if (Character.isDigit(c)) {
                    f = false;
                    break;
                }
            }
            if (!f) {
                continue;
            }
            if (s1.contains("-")) {
                int cnt = 0;
                for (char c : s1.toCharArray()) {
                    if (c == '-') {
                        cnt++;
                    }
                }
                if (cnt >= 2) {
                    f = false;
                } else {
                    int i = s1.indexOf('-');
                    if (i == 0 || i == s1.length() - 1) {
                        f = false;
                    } else {
                        if (!Character.isAlphabetic(s1.charAt(i - 1)) || !Character.isAlphabetic(s1.charAt(i + 1))) {
                            f = false;
                        }
                    }
                }
            }
            if (!f) {
                continue;
            }
            for (int i = 0; i < s1.length() - 1; i++) {
                if (s1.charAt(i) == '!' || s1.charAt(i) == '.' || s1.charAt(i) == ',') {
                    f = false;
                    break;
                }
            }
            if (f) {
                res++;
            }
        }
        return res;
    }
}
