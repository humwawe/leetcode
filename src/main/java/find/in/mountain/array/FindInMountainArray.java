package find.in.mountain.array;

/**
 * @author hum
 */
public class FindInMountainArray {
    int tar;

    public int findInMountainArray(int target, MountainArray mountainArr) {
        this.tar = target;
        int len = mountainArr.length();
        int l = 0;
        int r = len - 1;
        int t = helper(l, r, mountainArr);
        System.out.println(t);
        int res = helper1(l, t, mountainArr);
        if (res != -1) {
            return res;
        }
        return helper2(t, r, mountainArr);
    }

    private int helper2(int l, int r, MountainArray mountainArr) {
        while (l <= r) {
            int mid = l + r >> 1;
            int tmp = mountainArr.get(mid);
            if (tmp == tar) {
                return mid;
            }
            if (tmp > tar) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    private int helper1(int l, int r, MountainArray mountainArr) {
        while (l <= r) {
            int mid = l + r >> 1;
            int tmp = mountainArr.get(mid);
            if (tmp == tar) {
                return mid;
            }
            if (tmp < tar) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    private int helper(int l, int r, MountainArray mountainArr) {
        while (l < r) {
            int mid = l + r >> 1;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    class MountainArray {
        public int get(int index) {
            return 0;
        }

        public int length() {
            return 100;
        }
    }
}
