package longest.absolute.file.path;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class LongestAbsoluteFilePath {
    public int lengthLongestPath(String input) {
        String[] lines = input.split("\n");
        TreeFilePath root = new TreeFilePath("");
        buildTree(lines, root, 0, 0, lines.length);
        return dfs(root);

    }

    private int dfs(TreeFilePath root) {
        int res = 0;
        if (root.val.contains(".")) {
            return root.val.length();
        }
        for (TreeFilePath child : root.childs) {
            int len = dfs(child);
            if (len != 0) {
                res = Math.max(res, len + root.val.replaceAll("\t", "").length());
            }
        }
        return res;
    }

    void buildTree(String[] paths, TreeFilePath root, int level, int start, int end) {
        for (int i = start; i < end; i++) {
            if (helper(paths[i]) == level) {
                TreeFilePath child = new TreeFilePath(paths[i]);
                root.childs.add(child);
                int next = end;
                for (int j = i + 1; j < end; j++) {
                    if (helper(paths[j]) == level) {
                        next = j;
                        break;
                    }
                }
                buildTree(paths, child, level + 1, i, next);
            }
        }
    }

    public int helper(String s) {
        int count = 0;
        int index = -1;
        while ((index = s.indexOf("\t", index)) > -1) {
            ++index;
            ++count;
        }
        return count;
    }

    class TreeFilePath {
        String val;
        List<TreeFilePath> childs;

        public TreeFilePath(String val) {
            this.val = val;
            this.childs = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        String s = "\t\t\t3333";
        System.out.println(s.lastIndexOf("\t") + 1);
    }
}
