package capacity.to.ship.packages.within.d.days;

/**
 * @author hum
 */
public class CapacityToShipPackagesWithinDDays {
    int d;

    public int shipWithinDays(int[] weights, int d) {
        this.d = d;
        int l = 1;
        int r = 30000000;
        while (l < r) {
            int mid = l + r >> 1;
            if (helper(weights, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean helper(int[] w, int n) {
        int sum = 0;
        int count = 0;
        for (int wei : w) {
            if (wei > n) {
                return false;
            }
            sum += wei;
            if (sum > n) {
                count++;
                sum = wei;
            }
        }
        return count <= d - 1;
    }

}

