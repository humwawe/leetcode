package validate.binary.tree.nodes;

/**
 * @author hum
 */
public class ValidateBinaryTreeNodes {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] inDegree = new int[n];
        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) {
                inDegree[leftChild[i]]++;
            }
            if (rightChild[i] != -1) {
                inDegree[rightChild[i]]++;
            }
        }
        int count = 0;
        int root = 0;
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                root = i;
                count++;
                if (count > 1) {
                    return false;
                }
            }
            if (inDegree[i] > 1) {
                return false;
            }
        }
        if (count != 1) {
            return false;
        }
        return helper(root, leftChild, rightChild) == n;
    }

    int helper(int root, int[] l, int[] r) {
        if (root == -1) {
            return 0;
        }
        int ll = helper(l[root], l, r);
        int rr = helper(r[root], l, r);
        return ll + rr + 1;
    }
}
