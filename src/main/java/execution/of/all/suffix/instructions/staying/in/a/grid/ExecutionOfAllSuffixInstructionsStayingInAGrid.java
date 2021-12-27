package execution.of.all.suffix.instructions.staying.in.a.grid;

/**
 * @author hum
 */
public class ExecutionOfAllSuffixInstructionsStayingInAGrid {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int len = s.length();
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            int x = startPos[0];
            int y = startPos[1];
            int j = i;
            for (; j < len; j++) {
                char c = s.charAt(j);
                if (c == 'L') {
                    y--;
                } else if (c == 'R') {
                    y++;
                } else if (c == 'U') {
                    x--;
                } else {
                    x++;
                }
                if (x < 0 || x >= n || y < 0 || y >= n) {
                    break;
                }
            }
            res[i] = j - i;
        }
        return res;
    }
}
