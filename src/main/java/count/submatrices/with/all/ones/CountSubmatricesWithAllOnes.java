package count.submatrices.with.all.ones;

/**
 * @author hum
 */
public class CountSubmatricesWithAllOnes {
    public int numSubmat(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int result = 0;
        for (int i = 0; i < row; i++) {
            int[] sum = new int[col];
            for (int j = i; j < row; j++) {
                for (int k = 0; k < col; k++) {
                    sum[k] += mat[j][k];
                }
                int count = j - i + 1;
                int cnt = 0;
                for (int k = 0; k < col; k++) {
                    if (sum[k] == count) {
                        cnt++;
                    } else {
                        result += cnt * (cnt + 1) / 2;
                        cnt = 0;
                    }
                }
            }
        }
        return result;
    }

}
