package delete.characters.to.make.fancy.string;

/**
 * @author hum
 */
public class DeleteCharactersToMakeFancyString {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder(s);
        int len = s.length();
        for (int i = len - 1; i >= 2; i--) {
            char a = s.charAt(i - 2);
            char b = s.charAt(i - 1);
            char c = s.charAt(i);
            if (a == b && b == c) {
                sb.deleteCharAt(i);
            }
        }
        return sb.toString();
    }
}
