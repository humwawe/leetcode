package longest.happy.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class LongestHappyString {
    public String longestDiverseString(int a, int b, int c) {
        List<T> list = new ArrayList<>();
        list.add(new T(a, 'a'));
        list.add(new T(b, 'b'));
        list.add(new T(c, 'c'));
        StringBuilder stringBuilder = new StringBuilder();
        while (list.get(0).n > 0 || list.get(1).n > 0 || list.get(2).n > 0) {
            list.sort((o1, o2) -> o2.n - o1.n);
            if (list.get(0).n == list.get(1).n) {
                if (list.get(0).n-- > 0) {
                    stringBuilder.append(list.get(0).ch);
                }
                if (list.get(1).n-- > 0) {
                    stringBuilder.append(list.get(1).ch);
                }
                continue;
            }
            if (stringBuilder.length() > 0 && stringBuilder.charAt(stringBuilder.length() - 1) == list.get(0).ch) {
                break;
            }
            if (list.get(0).n-- > 0) {
                stringBuilder.append(list.get(0).ch);
            }
            if (list.get(0).n-- > 0) {
                stringBuilder.append(list.get(0).ch);
            }
            if (list.get(1).n-- > 0) {
                stringBuilder.append(list.get(1).ch);
            }
        }
        return stringBuilder.toString();
    }

    class T {
        int n;
        char ch;

        public T(int n, char ch) {
            this.n = n;
            this.ch = ch;
        }
    }
}
