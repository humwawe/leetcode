package rotating.the.box;

/**
 * @author hum
 */
public class RotatingTheBox {
    public char[][] rotateTheBox(char[][] box) {
        int n = box.length;
        int m = box[0].length;
        for (int i = 0; i < n; i++) {
            int obstacle = m;
            for (int j = m - 1; j >= 0; j--) {
                if (box[i][j] == '*') {
                    obstacle = j;
                } else if (box[i][j] == '#') {
                    box[i][j] = '.';
                    box[i][obstacle - 1] = '#';
                    obstacle = obstacle - 1;
                }
            }
        }
        char[][] res = new char[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[j][i] = box[n - 1 - i][j];
            }
        }
        return res;
    }
}
