package check.numbers.are.ascending.in.a.sentence;

/**
 * @author hum
 */
public class CheckIfNumbersAreAscendingInASentence {
    public boolean areNumbersAscending(String s) {
        String[] ss = s.split(" ");
        int last = -1;
        for (String s1 : ss) {
            if (Character.isDigit(s1.charAt(0))) {
                int tmp = Integer.parseInt(s1);
                if (tmp <= last) {
                    return false;
                }
                last = tmp;
            }
        }
        return true;
    }
}
