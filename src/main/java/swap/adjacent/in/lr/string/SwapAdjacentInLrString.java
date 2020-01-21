package swap.adjacent.in.lr.string;

public class SwapAdjacentInLrString {
    public boolean canTransform(String start, String end) {
        int len = start.length();
        int i = 0, j = 0;
        while (i < len && j < len) {
            while (i < len && start.charAt(i) == 'X') {
                ++i;
            }
            while (j < len && end.charAt(j) == 'X') {
                ++j;
            }
            if (i == len && j == len) {
                return true;
            } else if (i == len || j == len || start.charAt(i) != end.charAt(j)) {
                return false;
            }
            if ((start.charAt(i) == 'L' && i < j) || (start.charAt(i) == 'R' && i > j)) {
                return false;
            }
            ++i;
            ++j;
        }
        return true;
    }
}
