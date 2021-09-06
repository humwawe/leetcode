package find.all.groups.of.farmland;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class FindAllGroupsOfFarmland {
    public int[][] findFarmland(int[][] land) {
        int row = land.length;
        int col = land[0].length;
        List<int[]> list = new ArrayList<>();
        boolean[][] vis = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (vis[i][j]) {
                    continue;
                }
                if (land[i][j] == 1) {
                    vis[i][j] = true;
                    int x = i;
                    int y = j;
                    while (y < col && land[i][y] == 1) {
                        y++;
                    }
                    while (x < row && land[x][j] == 1) {
                        x++;
                    }
                    list.add(new int[]{i, j, x - 1, y - 1});
                    for (int k = i; k <= x - 1; k++) {
                        for (int l = j; l <= y - 1; l++) {
                            vis[k][l] = true;
                        }
                    }
                }
            }
        }
        return list.toArray(new int[list.size()][4]);
    }
}
