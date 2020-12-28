package determine.string.halves.are.alike;

/**
 * @author hum
 */
public class DetermineIfStringHalvesAreAlike {
    public boolean halvesAreAlike(String s) {
        int a = 0, b = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                if (i < (n / 2)) {
                    a++;
                } else {
                    a--;
                }
            }
        }
        return a == 0;
    }
}
