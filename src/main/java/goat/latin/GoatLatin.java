package goat.latin;

/**
 * @author hum
 */
public class GoatLatin {
    public String toGoatLatin(String s) {
        String[] split = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        int count = 1;
        for (String s1 : split) {
            if (helper(s1.charAt(0))) {
                stringBuilder.append(s1);
            } else {
                stringBuilder.append(s1.substring(1));
                stringBuilder.append(s1.charAt(0));
            }
            stringBuilder.append("ma");
            for (int i = 0; i < count; i++) {
                stringBuilder.append('a');
            }
            count++;
            stringBuilder.append(' ');
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    private boolean helper(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
