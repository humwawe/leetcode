package replace.all.to.avoid.consecutive.repeating.characters;

/**
 * @author hum
 */
public class ReplaceAllToAvoidConsecutiveRepeatingCharacters {
    public String modifyString(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '?') {
                char a = 'a';
                while ((i > 0 && chars[i - 1] == a) || (i < n - 1 && chars[i + 1] == a)) {
                    a++;
                }
                chars[i] = a;
            }
        }
        return new String(chars);
    }
}
