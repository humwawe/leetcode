package cat.and.mouse.II;

/**
 * @author hum
 */
public class CatAndMouseII {
    char[][] g;
    int row;
    int col;
    int catJump;
    int mouseJump;
    int[][] fs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int[] end = new int[2];
    Integer[][][][][] vis = new Integer[10][10][10][10][210];

    public boolean canMouseWin(String[] grid, int catJump, int mouseJump) {
        row = grid.length;
        col = grid[0].length();
        g = new char[row][col];
        int[] cat = new int[2];
        int[] mouse = new int[2];
        this.mouseJump = mouseJump;
        this.catJump = catJump;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                g[i][j] = grid[i].charAt(j);
                if (g[i][j] == 'C') {
                    cat[0] = i;
                    cat[1] = j;
                }
                if (g[i][j] == 'M') {
                    mouse[0] = i;
                    mouse[1] = j;
                }
                if (g[i][j] == 'F') {
                    end[0] = i;
                    end[1] = j;
                }
            }
        }
        return dfs(cat[0], cat[1], mouse[0], mouse[1], 0);
    }

    private boolean dfs(int catX, int catY, int mouseX, int mouseY, int step) {
        if (vis[catX][catY][mouseX][mouseY][step] != null) {
            return vis[catX][catY][mouseX][mouseY][step] == 1;
        }
        if ((step & 1) == 0) {
            if (step == 100) {
                vis[catX][catY][mouseX][mouseY][step] = 2;
                return false;
            }
            for (int[] f : fs) {
                for (int i = 1; i <= mouseJump; i++) {
                    int x = mouseX + f[0] * i;
                    int y = mouseY + f[1] * i;
                    if (x >= 0 && x < row && y >= 0 && y < col) {
                        if (g[x][y] == '#') {
                            break;
                        }
                        if (x == end[0] && y == end[1]) {
                            vis[catX][catY][mouseX][mouseY][step] = 1;
                            return true;
                        }
                        if (dfs(catX, catY, x, y, step + 1)) {
                            vis[catX][catY][mouseX][mouseY][step] = 1;
                            return true;
                        }
                    }
                }
            }
            if (dfs(catX, catY, mouseX, mouseY, step + 1)) {
                vis[catX][catY][mouseX][mouseY][step] = 1;
                return true;
            }
            return false;
        } else {
            if (catX == mouseX && catY == mouseY) {
                vis[catX][catY][mouseX][mouseY][step] = 2;
                return false;
            }
            for (int[] f : fs) {
                for (int i = 1; i <= catJump; i++) {
                    int x = catX + f[0] * i;
                    int y = catY + f[1] * i;
                    if (x >= 0 && x < row && y >= 0 && y < col) {
                        if (g[x][y] == '#') {
                            break;
                        }
                        if (x == end[0] && y == end[1]) {
                            vis[catX][catY][mouseX][mouseY][step] = 2;
                            return false;
                        }
                        if (x == mouseX && y == mouseY) {
                            vis[catX][catY][mouseX][mouseY][step] = 2;
                            return false;
                        }
                        if (!dfs(x, y, mouseX, mouseY, step + 1)) {
                            vis[catX][catY][mouseX][mouseY][step] = 2;
                            return false;
                        }
                    }
                }
            }
            if (!dfs(catX, catY, mouseX, mouseY, step + 1)) {
                vis[catX][catY][mouseX][mouseY][step] = 2;
                return false;
            }
            vis[catX][catY][mouseX][mouseY][step] = 1;
            return true;
        }
    }
}
