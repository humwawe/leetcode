package step.by.step.directions.from.a.binary.tree.node.to.another;

import common.TreeNode;

/**
 * @author hum
 */
public class StepByStepDirectionsFromABinaryTreeNodeToAnother {
    String st, dt;
    int sv, dv;

    public String getDirections(TreeNode root, int startValue, int destValue) {
        sv = startValue;
        dv = destValue;
        dfs(root, new StringBuilder());
        int i = 0;
        for (; i < Math.min(st.length(), dt.length()); i++) {
            if (st.charAt(i) != dt.charAt(i)) {
                break;
            }
        }
        st = st.substring(i);
        dt = dt.substring(i);
        StringBuilder res = new StringBuilder();
        for (int j = 0; j < st.length(); j++) {
            res.append("U");
        }
        return res.append(dt).toString();
    }

    private void dfs(TreeNode root, StringBuilder sb) {
        if (st != null && dt != null) {
            return;
        }
        if (root == null) {
            return;
        }
        if (root.val == sv) {
            st = sb.toString();
        } else if (root.val == dv) {
            dt = sb.toString();
        }
        sb.append("L");
        dfs(root.left, sb);
        sb.deleteCharAt(sb.length() - 1);
        sb.append("R");
        dfs(root.right, sb);
        sb.deleteCharAt(sb.length() - 1);
    }
}
