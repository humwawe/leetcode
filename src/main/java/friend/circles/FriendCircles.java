package friend.circles;


/**
 * @author hum
 */
public class FriendCircles {
    private int[] c;

    public int findCircleNum(int[][] m) {
        int row = m.length;
        if (row == 0) {
            return 0;
        }
        int col = m[0].length;
        c = new int[row];
        for (int i = 0; i < row; i++) {
            c[i] = i;
        }
        for (int i = 0; i < row; i++) {
            for (int j = i; j < col; j++) {
                if (m[i][j] == 1) {
                    int iParent = find(i);
                    int jParent = find(j);
                    if (iParent != jParent) {
                        c[jParent] = iParent;
                    }
                }
            }
        }

        int result = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] == i) {
                result++;
            }
        }
        return result;
    }

    private int find(int i) {
        if (c[i] != i) {
            return find(c[i]);
        } else {
            return i;
        }
    }

}
