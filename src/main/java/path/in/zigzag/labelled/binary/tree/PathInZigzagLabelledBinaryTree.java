package path.in.zigzag.labelled.binary.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @author hum
 */
public class PathInZigzagLabelledBinaryTree {
    public List<Integer> pathInZigZagTree(int label) {
        int level = 0;
        while (Math.pow(2, level) <= label) {
            level++;
        }
        LinkedList<Integer> result = new LinkedList<>();
        result.addFirst(label);
        int n = level - 1;
        boolean flag = true;
        while (n >= 1) {
            int sumLevel = (int) Math.pow(2, n) + (int) Math.pow(2, n - 1) - 1;
            if (flag) {
                result.addFirst(sumLevel - label / 2);
                flag = false;
            } else {
                result.addFirst(label / 2);
                flag = true;
            }

            label = label / 2;
            n--;
        }
        return result;

    }
}
