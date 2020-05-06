package recover.binary.search.tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;


/**
 * @author hum
 */
public class RecoverBinarySearchTree {
    public void recoverTree(TreeNode root) {
        List<TreeNode> inOrderResult = new ArrayList<>();
        inOrder(root, inOrderResult);
        int index = 0;
        while (index < inOrderResult.size() - 1) {
            if (inOrderResult.get(index).val > inOrderResult.get(index + 1).val) {
                break;
            }
            index++;
        }
        int minIndex = index;
        for (int i = index + 1; i < inOrderResult.size(); i++) {
            if (inOrderResult.get(i).val < inOrderResult.get(minIndex).val) {
                minIndex = i;
            }
        }
        System.out.println(index + " " + minIndex);
        int tmp = inOrderResult.get(index).val;
        inOrderResult.get(index).val = inOrderResult.get(minIndex).val;
        inOrderResult.get(minIndex).val = tmp;

    }

    private void inOrder(TreeNode root, List<TreeNode> inOrderResult) {
        if (root != null) {
            inOrder(root.left, inOrderResult);
            inOrderResult.add(root);
            inOrder(root.right, inOrderResult);
        }
    }

}
