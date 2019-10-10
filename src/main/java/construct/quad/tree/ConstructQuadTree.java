package construct.quad.tree;

import common.QuadNode;

/**
 * @author hum
 */
public class ConstructQuadTree {
    public QuadNode construct(int[][] grid) {
        int len = grid.length;
        return helper(grid, 0, len, 0, len);
    }

    public QuadNode helper(int[][] grid, int startRow, int endRow, int startCol, int endCol) {
        boolean flag;
        flag = grid[startRow][startCol] != 0;
        if (isLeaf(grid, startRow, endRow, startCol, endCol)) {
            return new QuadNode(flag, true, null, null, null, null);
        }
        QuadNode root = new QuadNode(flag, false, null, null, null, null);
        root.topLeft = helper(grid, startRow, startRow + (endRow - startRow) / 2, startCol, startCol + (endCol - startCol) / 2);
        root.topRight = helper(grid, startRow, startRow + (endRow - startRow) / 2, startCol + (endCol - startCol) / 2 + 1, endCol);
        root.bottomLeft = helper(grid, startRow + (endRow - startRow) / 2 + 1, endRow, startCol, startCol + (endCol - startCol) / 2);
        root.bottomRight = helper(grid, startRow + (endRow - startRow) / 2 + 1, endRow, startCol + (endCol - startCol) / 2 + 1, endCol);
        return root;
    }

    private boolean isLeaf(int[][] grid, int startRow, int endRow, int startCol, int endCol) {
        int cons = grid[startRow][startCol];
        for (int i = startRow; i <= endRow; i++) {
            for (int j = startCol; j <= endCol; j++) {
                if (grid[i][j] != cons) {
                    return false;
                }
            }
        }
        return true;
    }

}
