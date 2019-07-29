package range.sum.query.mutable;

/**
 * @author hum
 */
public class RangeSumQueryMutable {
    int[] tree;
    int len;
    int[] nums;

    public RangeSumQueryMutable(int[] nums) {

        len = nums.length;
        if (len == 0) {
            return;
        }
        tree = new int[len * 4];
        this.nums = nums;
        buildTree(nums, 0, 0, len - 1);
    }

    public void buildTree(int[] num, int node, int start, int end) {
        if (start == end) {
            tree[node] = num[start];
            return;
        }
        int mid = (start + end) / 2;
        int leftNode = 2 * node + 1;
        int rightNode = 2 * node + 2;
        buildTree(num, leftNode, start, mid);
        buildTree(num, rightNode, mid + 1, end);
        tree[node] = tree[leftNode] + tree[rightNode];
    }


    public void update(int i, int val) {
        int start = 0;
        int end = len - 1;
        int node = 0;
        int delta = val - nums[i];
        while (start != end) {
            tree[node] += delta;
            int mid = start + (end - start) / 2;
            if (mid >= i) {
                end = mid;
                node = 2 * node + 1;
            } else {
                start = mid + 1;
                node = 2 * node + 2;
            }
        }
        tree[node] += delta;
        nums[i] = val;

    }

    public int sumRange(int i, int j) {
        return sumRange(0, 0, len - 1, i, j);
    }

    private int sumRange(int node, int start, int end, int left, int right) {

        if (left == start && right == end) {
            return tree[node];
        }

        int mid = start + (end - start) / 2;
        int leftNode = 2 * node + 1;
        int rightNode = 2 * node + 2;
        if (mid >= right) {
            return sumRange(leftNode, start, mid, left, right);
        } else if (left > mid) {
            return sumRange(rightNode, mid + 1, end, left, right);
        }
        int sumLeft = sumRange(leftNode, start, mid, left, mid);
        int sumRight = sumRange(rightNode, mid + 1, end, mid + 1, right);
        return sumLeft + sumRight;
    }
}
