package unique.letter.string;


import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class UniqueLetterString {
    public int uniqueLetterString(String s) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(-1);
            lists.add(list);
        }
        for (int i = 0; i < s.length(); i++) {
            lists.get(s.charAt(i) - 'A').add(i);
        }
        int len = s.length();
        for (int i = 0; i < 26; i++) {
            lists.get(i).add(len);
        }
        long result = 0;
        int mod = (int) 1e9 + 7;
        for (int i = 0; i < 26; i++) {
            List<Integer> list = lists.get(i);
            for (int j = 1; j < list.size() - 1; j++) {
                result += (list.get(j) - list.get(j - 1)) * (list.get(j + 1) - list.get(j));
            }
        }
        return (int) (result % mod);
    }
}
