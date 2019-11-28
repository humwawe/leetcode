package reshape.the.matrix;

public class ReshapeTheMatrix {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int row = nums.length;
        int col = nums[0].length;
        if (row * col != r * c) {
            return nums;
        }
        int[][] result = new int[r][c];
        int x = 0, y = 0;

        for (int[] num : nums) {
            for (int i : num) {
                result[x][y] = i;
                y++;
                if (y == c) {
                    x++;
                    y = 0;
                }
            }
        }
        return result;
    }
}
