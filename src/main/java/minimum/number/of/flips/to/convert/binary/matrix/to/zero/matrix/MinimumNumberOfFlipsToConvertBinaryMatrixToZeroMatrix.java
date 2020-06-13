package minimum.number.of.flips.to.convert.binary.matrix.to.zero.matrix;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * @author hum
 */
public class MinimumNumberOfFlipsToConvertBinaryMatrixToZeroMatrix {
    int row;
    int col;
    int[][] fs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int minFlips(int[][] mat) {
        row = mat.length;
        col = mat[0].length;
        StringBuilder t = new StringBuilder();
        for (int i = 0; i < row * col; i++) {
            t.append("0");
        }
        String tar = t.toString();
        String s = mat2Str(mat);
        Queue<String> queue = new ArrayDeque<>();
        Set<String> vis = new HashSet<>();
        queue.add(s);
        vis.add(s);
        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String poll = queue.poll();
                if (poll.equals(tar)) {
                    return result;
                }
                int[][] tmp = str2Mat(poll);
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < col; j++) {
                        int[][] next = getNext(tmp, i, j);
                        String ss = mat2Str(next);
                        if (vis.contains(ss)) {
                            continue;
                        }
                        queue.add(ss);
                        vis.add(ss);
                    }
                }
            }
            result++;
        }
        return -1;
    }

    private int[][] getNext(int[][] m, int i, int j) {
        int[][] tmp = new int[row][col];
        for (int k = 0; k < row; k++) {
            for (int l = 0; l < col; l++) {
                tmp[k][l] = m[k][l];
            }
        }
        tmp[i][j] = 1 - tmp[i][j];
        for (int[] f : fs) {
            int x = i + f[0];
            int y = j + f[1];
            if (x >= 0 && x < row && y >= 0 && y < col) {
                tmp[x][y] = 1 - tmp[x][y];
            }
        }
        return tmp;
    }

    private String mat2Str(int[][] mat) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                s.append(mat[i][j]);
            }
        }
        return s.toString();
    }

    private int[][] str2Mat(String s) {
        int[][] res = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                res[i][j] = s.charAt(i * col + j) - '0';
            }
        }
        return res;
    }
}
