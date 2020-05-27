package alphabet.board.path;

/**
 * @author hum
 */
public class AlphabetBoardPath {
    public String alphabetBoardPath(String target) {
        int r = 0;
        int l = 0;
        StringBuilder result = new StringBuilder();
        for (char c : target.toCharArray()) {
            int[] pos = helper(c);
            while (l > pos[1]) {
                l--;
                result.append("L");
            }
            while (r > pos[0]) {
                r--;
                result.append("U");
            }
            while (l < pos[1]) {
                l++;
                result.append("R");
            }
            while (r < pos[0]) {
                r++;
                result.append("D");
            }
            result.append("!");
        }
        return result.toString();
    }

    private int[] helper(char c) {
        int t = c - 'a';
        int a = t / 5;
        int b = t % 5;
        return new int[]{a, b};
    }

}
