package reverse.only.letters;

/**
 * @author hum
 */
public class ReverseOnlyLetters {
    public String reverseOnlyLetters(String s) {
        StringBuilder result = new StringBuilder(s);
        int j = s.length() - 1;
        int i = 0;
        while (i < j) {
            while (i < j && !Character.isAlphabetic(result.charAt(i))) {
                i++;
            }
            while (i < j && !Character.isAlphabetic(result.charAt(j))) {
                j--;
            }
            char tmp = result.charAt(i);
            result.setCharAt(i, result.charAt(j));
            result.setCharAt(j, tmp);
            i++;
            j--;
        }
        return result.toString();
    }
}
