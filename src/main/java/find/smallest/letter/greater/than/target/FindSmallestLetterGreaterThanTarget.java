package find.smallest.letter.greater.than.target;

/**
 * @author hum
 */
public class FindSmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        char c = 'z';
        char min = 'z';
        boolean flag = false;
        for (char letter : letters) {
            if (letter > target) {
                flag = true;
                c = (char) Math.min(c, letter);
            }
            min = (char) Math.min(min, letter);
        }
        if (!flag) {
            return min;
        }
        return c;
    }
}
