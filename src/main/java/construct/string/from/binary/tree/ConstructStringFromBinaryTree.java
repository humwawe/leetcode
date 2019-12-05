package construct.string.from.binary.tree;

import common.TreeNode;

/**
 * @author hum
 */
public class ConstructStringFromBinaryTree {
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        String l = tree2str(t.left);
        String r = tree2str(t.right);
        if ("".equals(l) && "".equals(r)) {
            return String.valueOf(t.val);
        }
        if ("".equals(l)) {
            return t.val + "()" + " (" + r + ") ";
        }
        if ("".equals(r)) {
            return t.val + "(" + l + ")" + "()";
        }
        return t.val + "(" + l + ")" + "(" + r + ")";
    }
}
