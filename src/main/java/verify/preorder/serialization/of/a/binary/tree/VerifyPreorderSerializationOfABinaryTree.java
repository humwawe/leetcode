package verify.preorder.serialization.of.a.binary.tree;


/**
 * @author hum
 */
public class VerifyPreorderSerializationOfABinaryTree {
    private int[][] memo;

    public boolean isValidSerialization(String preorder) {
        String[] values = preorder.split(",");

//        int len = values.length;
//        int leaves = 0, node = 0;
//        for (int i = 0; i < len; i++) {
//            String value = values[i];
//            if ("#".equals(value)) {
//                leaves++;
//            } else {
//                node++;
//            }
//            if (leaves > node + 1) {
//                return false;
//
//            }
//            if (leaves == node + 1 && i != len - 1) {
//                return false;
//            }
//        }
//        return leaves == node + 1;

        int count = 0;
        if (!check(values, 0, values.length - 1)) {
            return false;
        }
        memo = new int[values.length + 1][values.length + 1];
        return helper(values, 0, values.length - 1);
    }

    private boolean helper(String[] values, int start, int len) {
        if (!check(values, start, len)) {
            memo[start][len] = -1;
            return false;
        }

        if (memo[start][len] != 0) {
            return memo[start][len] == 1;
        }

        if (start == len && "#".equals(values[start])) {
            memo[start][len] = 1;
            return true;
        }
        if (len > start && "#".equals(values[start])) {
            memo[start][len] = -1;
            return false;
        }


//        for (int i = start + 1; i <= len; i++) {
//            if ("#".equals(values[i])) {
//                boolean left = helper(values, start + 1, i);
//                boolean right = helper(values, i + 1, len);
//                if (left & right) {
//                    memo[start][len] = 1;
//                    return true;
//                }
//            }
//        }
        int pos = pos(values, start);
        if (pos != -1) {
            boolean left = helper(values, start + 1, pos);
            boolean right = helper(values, pos + 1, len);
            if (left & right) {
                memo[start][len] = 1;
                return true;
            }
        }
        memo[start][len] = -1;
        return false;
    }


    public int pos(String[] values, int begin) {
        int count1 = 0;
        int count2 = 0;
        int length = values.length;
        for (int i = begin + 1; i < length; i++) {
            if (!"#".equals(values[i])) {
                count1++;
            } else {
                count2++;
            }
            if (count2 > count1) {
                return i;
            }
        }
        return -1;
    }


    private boolean check(String[] values, int start, int end) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            if ("#".equals(values[i])) {
                count++;
            } else {
                count--;
            }
        }
        return count == 1;
    }
}
