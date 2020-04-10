package regions.cut.by.slashes;

/**
 * @author hum
 */
public class RegionsCutBySlashes {
    public int regionsBySlashes(String[] grid) {
        int len = grid.length;
        boolean[][] graph = new boolean[len * 3][len * 3];
        for (int i = 0; i < len; ++i) {
            for (int j = 0; j < len; ++j) {
                if (grid[i].charAt(j) == '/') {
                    graph[i * 3][j * 3 + 2] = true;
                    graph[i * 3 + 1][j * 3 + 1] = true;
                    graph[i * 3 + 2][j * 3] = true;
                } else if (grid[i].charAt(j) == '\\') {
                    graph[i * 3][j * 3] = true;
                    graph[i * 3 + 1][j * 3 + 1] = true;
                    graph[i * 3 + 2][j * 3 + 2] = true;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < len * 3; ++i) {
            for (int j = 0; j < len * 3; ++j) {
                if (!graph[i][j]) {
                    dfs(graph, i, j);
                    res++;
                }
            }
        }
        return res;

    }

    private void dfs(boolean[][] graph, int i, int j) {
        int len = graph.length;
        if (i >= 0 && j >= 0 && i < len && j < len && !graph[i][j]) {
            graph[i][j] = true;
            dfs(graph, i, j - 1);
            dfs(graph, i, j + 1);
            dfs(graph, i - 1, j);
            dfs(graph, i + 1, j);
        }
    }
}
